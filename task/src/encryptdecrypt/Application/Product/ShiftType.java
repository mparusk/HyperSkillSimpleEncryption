package encryptdecrypt.Application.Product;

public abstract class ShiftType {
    protected int key;
    protected String encryptable;
    protected String mode;
    public static char[] unicodeArray;

    public abstract String shift();

    public ShiftType(int key, String encryptable, String mode){
        this.key = key;
        this.encryptable = encryptable;
        this.mode = mode;
    }

    public static void generateScale(){
        unicodeArray = new char[400];
        for (int i = 0; i < 400; i++){
            unicodeArray[i] = (char) i;
        }
    }

}
