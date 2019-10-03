package encryptdecrypt.Application.Product.Rules;

public class JumpRule {
    private int[] jumpFrom;
    private int[] jumpTo;


    public JumpRule(int[] jumpFrom, int[] jumpTo){
        this.addArrays(jumpFrom, jumpTo);
    }

    private void addArrays(int[] jumpFrom, int[] jumpTo){
        if(jumpArrayIsValid(jumpFrom, jumpTo)){
            this.jumpFrom = jumpFrom;
            this.jumpTo = jumpTo;
        } else {
            System.out.println("Error: invalid array");
            System.exit(1);
        }
    }

    private boolean jumpArrayIsValid(int[] jumpFrom, int[] jumpTo){
        return (jumpFrom.length == jumpTo.length) || (jumpFrom.length >0);
    }

    public int enforceRule(int character){
        for (int i = 0; i < jumpFrom.length; i++){
            if (character == jumpFrom[i]){
                System.out.println(character + " " + jumpFrom[i] + " match");
                System.out.println("returning " + jumpTo[i] + " " + (char) jumpTo[i]);
                return (int) jumpTo[i];
            }
        }
        return -1;
    }
}
