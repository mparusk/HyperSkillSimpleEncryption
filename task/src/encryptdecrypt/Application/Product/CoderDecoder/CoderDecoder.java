package encryptdecrypt.Application.Product.CoderDecoder;

import encryptdecrypt.Application.Product.Rule.Rule;

public abstract class CoderDecoder {
    Rule rule = null;

    public abstract String transform(String decryptable, int key);

    public void setRule(Rule rule){
        this.rule = rule;
    }


}
