package encryptdecrypt.Application.Product.CoderDecoder;

import encryptdecrypt.Application.Product.Rules.JumpRule;
import encryptdecrypt.Application.Product.ShiftType;

public class Encrypter extends CoderDecoder {
    public String transform(String encryptable, int key){
        char[] unencryptedArray = encryptable.toCharArray();
        char[] encryptedArray = new char[unencryptedArray.length];

        if (jumpRule != null){
            for (int i = 0; i < unencryptedArray.length; i++) {
                encryptedArray[i] = this.shiftCharacter(unencryptedArray[i],
                        key, jumpRule);
            }
        } else {
            for (int i = 0; i < unencryptedArray.length; i++){
                encryptedArray[i] = this.shiftCharacter(unencryptedArray[i],
                        key);
            }
        }

        return String.valueOf(encryptedArray);
    }

    private char shiftCharacter(char shiftableChar, int key, JumpRule jumpRule){
       for (int i = 0; i < key; i++){
           int isJumpCase = jumpRule.enforceRule(shiftableChar);

           if (isJumpCase == -1){
               shiftableChar++;
           } else {
               shiftableChar = (char) isJumpCase;
           }
       }

       return shiftableChar;
    }

    private char shiftCharacter(char shiftableChar, int key){
        return ShiftType.unicodeArray[shiftableChar + key];
    }
}
