package encryptdecrypt.Application.Client;


import encryptdecrypt.Application.Factory.*;

import java.io.*;
import java.util.Scanner;

/**
 * Separate class for processing the encryption.
 * Subclass: extracter and outputter. Went for inner classes to have better
 * access to local vars.
 */
class EncryptionExcercise {
    //Data from arguments
    private int key = 0;
    private String mode = "enc";
    private String data = "";
    private String algorithm = "shift";
    private String fileOutName = "";

    //Other
    private ArgsUtils argsUtils;
    private Extracter extracter;

    EncryptionExcercise(String[] args){
        argsUtils = new ArgsUtils(args);
        extracter = new Extracter(args);
        this.flow();
    }

    private void flow(){
        Factory factory;

        //Checker
        argsUtils.checkIfValidArguments();

        //Incoming data extracter
        extracter.extract();

        //Algorithm
        if (algorithm.equals("unicode")){
            System.out.println("unic");
            factory = new UnicodeEncryptFactory();
        } else {
            System.out.println("shift");
            factory = new AlphabetEncryptFactory();
        }

        //Outgoing
        String result = factory.processEncryption(key, data, mode);
        System.out.println(result);
        Outputter outputter = new Outputter(result);
        outputter.output();
    }

    //To handle the input
    private class Extracter{
        String[] args;

        private Extracter(String[] args){
            this.args = args;
        }

        private void extract(){

            for (int i = 0; i < args.length; i +=2){
                if (args[i].equals("-mode")){
                    mode = args[i+1];

                } else if (args[i].equals("-key")){
                    key = Integer.parseInt(args[i+1]);

                } else if (args[i].equals("-data")){
                    data = args[i+1];

                } else if (args[i].equals("-in")){
                    if(data.equals("")){ data = readFile(args[i+1]); }

                } else if (args[i].equals("-out")) {
                    fileOutName = args[i + 1];

                } else if (args[i].equals("-alg")){
                    algorithm = args[i + 1];
                }
            }
        }

        private String readFile(String fileInName){
            try {
                Scanner scanner = new Scanner(new File(fileInName));
                return scanner.nextLine();
            } catch (FileNotFoundException e){
                System.out.println("Error: file non-existent");
                System.exit(1);
                return null;
            }
        }
    }

    //To handle writing the result to a file
    private class Outputter{
        private String toOutput;

        private Outputter(String result) {
            this.toOutput = result;
        }

        private void output(){
            if (fileOutName.equals("")){
                System.out.println(toOutput);
            } else {

                try {
                    FileWriter fileWriter = new FileWriter(fileOutName);
                    fileWriter.write(toOutput);
                    fileWriter.close();
                } catch (IOException e){
                    System.out.println("Error: problem writing to file");
                    System.exit(1);
                }
            }
        }
    }
}
