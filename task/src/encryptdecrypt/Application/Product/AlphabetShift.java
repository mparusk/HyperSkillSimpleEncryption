package encryptdecrypt.Application.Product;

import encryptdecrypt.Application.Product.CoderDecoder.CoderDecoder;
import encryptdecrypt.Application.Product.CoderDecoder.Decrypter;
import encryptdecrypt.Application.Product.CoderDecoder.Encrypter;
import encryptdecrypt.Application.Product.Rules.JumpRule;

public class AlphabetShift extends ShiftType {
    private JumpRule jumpRule;

    public AlphabetShift(int key, String encryptable, String mode){
        super(key, encryptable, mode);
    }

    public String shift(){
        CoderDecoder coderDecoder;
        this.createRule();

        if (mode.equals("enc")){
            coderDecoder = new Encrypter();
        } else {
            coderDecoder = new Decrypter();
        }

        coderDecoder.setJumpRule(jumpRule);
        return coderDecoder.transform(encryptable, key);
    }

    private void createRule(){
        if (mode.equals("enc")){
            int[] jumpFrom = new int[]{122, 90, 32};
            int[] jumpTo = new int[]{97, 65, 32};
            jumpRule = new JumpRule(jumpFrom, jumpTo);
        } else {
            int[] jumpFrom = new int[]{97, 65, 32};
            int[] jumpTo = new int[]{122, 90, 32};
            jumpRule = new JumpRule(jumpFrom, jumpTo);
        }
    }
}
