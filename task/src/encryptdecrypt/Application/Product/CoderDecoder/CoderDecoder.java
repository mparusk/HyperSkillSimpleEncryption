package encryptdecrypt.Application.Product.CoderDecoder;

import encryptdecrypt.Application.Product.Rules.JumpRule;

public abstract class CoderDecoder {
    protected JumpRule jumpRule = null;
    protected char[] scale;

    public CoderDecoder(char[] scale){
        this.scale = scale;
    }

    public abstract String transform(String decryptable, int key);

    public void setJumpRule(JumpRule jumpRule){
        this.jumpRule = jumpRule;
    }
}
