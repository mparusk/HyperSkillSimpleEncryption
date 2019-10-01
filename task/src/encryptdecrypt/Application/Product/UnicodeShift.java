package encryptdecrypt.Application.Product;

import encryptdecrypt.Application.Product.CoderDecoder.CoderDecoder;
import encryptdecrypt.Application.Product.CoderDecoder.Decrypter;
import encryptdecrypt.Application.Product.CoderDecoder.Encrypter;

public class UnicodeShift extends ShiftType {
    private int key;
    private String encryptable;
    private String mode;
    private CoderDecoder coderDecoder;


    public UnicodeShift(int key, String encryptable, String mode) {
        this.key = key;
        this.encryptable = encryptable;
        this.mode = mode;
    }

    public String shift(){
        if (mode.equals("enc")){
            coderDecoder = new Encrypter();
        } else {
            coderDecoder = new Decrypter();
        }

        return coderDecoder.transform(encryptable, key);
    }


}
