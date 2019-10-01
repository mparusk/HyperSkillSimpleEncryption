package encryptdecrypt.Application.Factory;

import encryptdecrypt.Application.Product.ShiftType;

public abstract class Factory {

    public abstract ShiftType createShift(int key, String encryptable,
                                            String mode);

    public String processEncryption(int key, String encryptable, String mode){
        ShiftType shiftEncryptionType = this.createShift(key, encryptable, mode);
        return shiftEncryptionType.shift();
    }
}
