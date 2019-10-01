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
    private String fileOut = "";

    //Other
    private Utils utils;
    private Extracter extracter;

    EncryptionExcercise(String[] args){
        utils = new Utils(args);
        extracter = new Extracter(args);
        this.flow();
    }

    private void flow(){
        Factory factory;

        //Checker
        utils.checkIfValidArgument();

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
                    fileOut = args[i + 1];

                } else if (args[i].equals("-alg")){
                    algorithm = args[i + 1];
                }
            }
        }

        private String readFile(String fileIn){
            try {
                Scanner scanner = new Scanner(new File(fileIn));
                return scanner.nextLine();
            } catch (FileNotFoundException e){
                System.out.println("Error: file non-existent");
                System.exit(1);
                return null;
            }
        }
    }

    private class Outputter{
        String result;

        private Outputter(String result) {
            this.result = result;
        }

        private void output(){
            if (fileOut.equals("")){
                System.out.println(result);
            } else {

                try {
                    FileWriter fileWriter = new FileWriter(fileOut);
                    fileWriter.write(result);
                    fileWriter.close();
                } catch (IOException e){
                    System.out.println("Error: problem writing to file");
                    System.exit(1);
                }
            }
        }
    }
}
