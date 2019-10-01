package encryptdecrypt.Application.Product.CoderDecoder;

import encryptdecrypt.Application.Product.Rule.Rule;
import encryptdecrypt.Application.Product.ShiftType;

public class Decrypter extends CoderDecoder {
    public String transform(String decryptable, int key){
        char[] encryptedArray = decryptable.toCharArray();
        char[] unencryptedArray = new char[encryptedArray.length];

        if (rule != null){
            for (int i = 0; i < encryptedArray.length; i++) {
                unencryptedArray[i] = this.shiftedNonLetter(encryptedArray[i],
                        key, rule);
            }
        } else {
            for (int i = 0; i < encryptedArray.length; i++){
                unencryptedArray[i] = this.shiftedNonLetter(encryptedArray[i], key);
            }
        }

        return String.valueOf(unencryptedArray);
    }

    private char shiftedNonLetter(char shiftableChar, int key, Rule rule){
        System.out.println("char " + shiftableChar + " with unic " + (int) shiftableChar);
        for (int i = 0; i < key; i++){
            int isJumpCase = rule.enforceRule(shiftableChar);

            if (isJumpCase == -1){
                shiftableChar--;
            } else {
                shiftableChar = (char) isJumpCase;
            }
        }

        return shiftableChar;

    }

    private char shiftedNonLetter(char shiftableChar, int key){
        return ShiftType.unicodeArray[shiftableChar - key];
    }
}
