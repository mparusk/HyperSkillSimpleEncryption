package encryptdecrypt.Application.Product;

public abstract class ShiftType {
    public static char[] unicodeArray;

    public abstract String shift();

    public static void generateScale(){
        unicodeArray = new char[400];
        for (int i = 0; i < 400; i++){
            unicodeArray[i] = (char) i;
        }
    }

}
