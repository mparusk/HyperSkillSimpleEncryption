package encryptdecrypt.Application.Product.Rule;

public abstract class Rule {
    private String name;
    private int[] jumpFrom;
    private int[] jumpTo;


    public Rule(String name, int[] jumpFrom, int[] jumpTo){
        this.name = name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getJumpFrom() {
        return jumpFrom;
    }

    public void setJumpFrom(int[] jumpFrom) {
        this.jumpFrom = jumpFrom;
    }

    public int[] getJumpTo() {
        return jumpTo;
    }

    public void setJumpTo(int[] jumpTo) {
        this.jumpTo = jumpTo;
    }
}
