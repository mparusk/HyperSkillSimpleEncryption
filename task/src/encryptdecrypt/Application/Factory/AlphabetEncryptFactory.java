package encryptdecrypt.Application.Factory;

import encryptdecrypt.Application.Product.AlphabetShift;
import encryptdecrypt.Application.Product.ShiftType;

public class AlphabetEncryptFactory extends Factory {

    public ShiftType createShift(int key, String encryptable, String mode){
        ShiftType.generateScale();
        return new AlphabetShift(key, encryptable, mode);
    }
}
