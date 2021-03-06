package encryptdecrypt.Application.Product.CoderDecoder;

import encryptdecrypt.Application.Product.Rules.JumpRule;
import encryptdecrypt.Application.Product.ShiftType;

public class Decrypter extends CoderDecoder {

    public Decrypter(char[] scale){
        super(scale);
    }

    public String transform(String decryptable, int key){
        char[] encryptedArray = decryptable.toCharArray();
        char[] unencryptedArray = new char[encryptedArray.length];

        if (jumpRule != null){
            for (int i = 0; i < encryptedArray.length; i++) {
                unencryptedArray[i] = this.shiftCharacter(encryptedArray[i],
                        key, jumpRule);
            }
        } else {
            for (int i = 0; i < encryptedArray.length; i++){
                unencryptedArray[i] = this.shiftCharacter(encryptedArray[i], key);
            }
        }

        return String.valueOf(unencryptedArray);
    }

    private char shiftCharacter(char shiftableChar, int key, JumpRule jumpRule){
        for (int i = 0; i < key; i++){
            int isJumpCase = jumpRule.enforceRule(shiftableChar);

            if (isJumpCase == -1){
                shiftableChar = scale[shiftableChar-1];
            } else {
                shiftableChar = (char) isJumpCase;
            }
        }

        return shiftableChar;
    }

    private char shiftCharacter(char shiftableChar, int key){
        return ShiftType.unicodeArray[shiftableChar - key];
    }
}
