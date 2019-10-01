package encryptdecrypt.Application.Product.CoderDecoder;

import encryptdecrypt.Application.Product.Rule.Rule;
import encryptdecrypt.Application.Product.ShiftType;

public class Encrypter extends CoderDecoder {
    public String transform(String encryptable, int key){
        char[] unencryptedArray = encryptable.toCharArray();
        char[] encryptedArray = new char[unencryptedArray.length];

        if (rule != null){
            for (int i = 0; i < unencryptedArray.length; i++) {
                encryptedArray[i] = this.shiftedNonLetter(unencryptedArray[i],
                        key, rule);
            }
        } else {
            for (int i = 0; i < unencryptedArray.length; i++){
                encryptedArray[i] = this.shiftedNonLetter(unencryptedArray[i],
                        key);
            }
        }

        return String.valueOf(encryptedArray);
    }

    private char shiftedNonLetter(char shiftableChar, int key, Rule rule){
        //System.out.println("char " + shiftableChar + " with unic " + (int)
        // shiftableChar);
       for (int i = 0; i < key; i++){
           int isJumpCase = rule.enforceRule(shiftableChar);

           if (isJumpCase == -1){
               shiftableChar++;
           } else {
               shiftableChar = (char) isJumpCase;
           }
       }

       return shiftableChar;
    }

    private char shiftedNonLetter(char shiftableChar, int key){
        return ShiftType.unicodeArray[shiftableChar + key];
    }
}
