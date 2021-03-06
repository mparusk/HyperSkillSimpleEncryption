package encryptdecrypt.Application.Client;

import java.util.Arrays;

class ArgsUtils {
    private String[] args;

    ArgsUtils(String[] args){
        this.args = args;
    }

    void checkIfValidArguments(){
        if (!(args.length % 2 == 0)){
            System.out.println("Error: invalid arguments");
            System.exit(1);
        }

        String[] arrOfInvalidArgs = new String[]{"-mode", "-key", "-data",
                "-in", "-alg", "-out"};

        for (int i = 0; i < args.length; i += 2){
            String tester = null;
            try {
                tester = args[i+1];
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error: invalid arguments");
                System.exit(1);
            }

            if (Arrays.asList(arrOfInvalidArgs).contains(args[i+1])){
                System.out.println("Error: invalid arguments");
                System.exit(1);
            }
        }
    }
}
