package encryptdecrypt.Application.Product;

import encryptdecrypt.Application.Product.CoderDecoder.CoderDecoder;
import encryptdecrypt.Application.Product.CoderDecoder.Decrypter;
import encryptdecrypt.Application.Product.CoderDecoder.Encrypter;
import encryptdecrypt.Application.Product.Rule.DecryptionJumpRule;
import encryptdecrypt.Application.Product.Rule.EncryptionJumpRule;
import encryptdecrypt.Application.Product.Rule.Rule;

public class AlphabetShift extends ShiftType {
    private int key;
    private String encryptable;
    private String mode;
    private CoderDecoder coderDecoder;
    private Rule rule;

    public AlphabetShift(int key, String encryptable, String mode){
        this.key = key;
        this.encryptable = encryptable;
        this.mode = mode;
    }

    public String shift(){
        System.out.println("begin create rule");
        this.createRule();
        System.out.println("rule done");

        if (mode.equals("enc")){
            coderDecoder = new Encrypter();
        } else {
            coderDecoder = new Decrypter();
        }

        coderDecoder.setRule(rule);
        System.out.println("rule set");
        return coderDecoder.transform(encryptable, key);
    }

    private void createRule(){
        if (mode.equals("enc")){
            int[] jumpFrom = new int[]{122, 90, 32, 33, 34, 35, 36, 37};
            int[] jumpTo = new int[]{97, 65, 32, 32, 32, 32, 32, 32};
            rule = new EncryptionJumpRule("Encryption  rule",jumpFrom, jumpTo);
            System.out.println("enc jumprule");
        } else {
            int[] jumpFrom = new int[]{97, 65, 27, 28, 29, 30, 31, 32};
            int[] jumpTo = new int[]{122, 90, 32, 32, 32, 32, 32, 32};
            rule = new DecryptionJumpRule("Decryption  rule",jumpFrom, jumpTo);
            System.out.println("dec jumprule");
        }
    }
}
