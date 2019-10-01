package encryptdecrypt.Application.Factory;

import encryptdecrypt.Application.Product.ShiftType;
import encryptdecrypt.Application.Product.UnicodeShift;

public class UnicodeEncryptFactory extends Factory {

    public ShiftType createShift(int key, String encryptable,
                                   String mode){
        ShiftType.generateScale();
        return new UnicodeShift(key, encryptable, mode);
    }
}
