package encryptdecrypt.Application.Client;

import java.util.Arrays;

public class Utils {
    String[] args;

    Utils(String[] args){
        this.args = args;
    }

    boolean checkIfValidArgument(){
        if (!(args.length % 2 == 0)){
            System.out.println("Error: invalid arguments");
            System.exit(1);
        }

        int counter = 0;
        String[] arrOfInvalidArgs = new String[]{"-mode", "-key", "-data",
                "-in", "-out"};

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

        return true;
    }
}
