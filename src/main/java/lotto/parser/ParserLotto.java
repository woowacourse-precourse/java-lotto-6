package lotto.parser;

import lotto.validator.Validate;

public class ParserLotto {
    public static int lottoParser(String money){
        Validate.moneyValidate(money);
        return Integer.parseInt(money);
    }
}
