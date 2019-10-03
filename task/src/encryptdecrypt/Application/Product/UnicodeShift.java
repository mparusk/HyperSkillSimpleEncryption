package encryptdecrypt.Application.Product;

import encryptdecrypt.Application.Product.CoderDecoder.CoderDecoder;
import encryptdecrypt.Application.Product.CoderDecoder.Decrypter;
import encryptdecrypt.Application.Product.CoderDecoder.Encrypter;

public class UnicodeShift extends ShiftType {

    public UnicodeShift(int key, String encryptable, String mode) {
       super(key, encryptable, mode);
    }

    public String shift(){
        CoderDecoder coderDecoder;

        if (mode.equals("enc")){
            coderDecoder = new Encrypter();
        } else {
            coderDecoder = new Decrypter();
        }

        return coderDecoder.transform(encryptable, key);
    }


}
