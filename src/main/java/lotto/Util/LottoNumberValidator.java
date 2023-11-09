package lotto.Util;

import java.util.ArrayList;

public class LottoNumberValidator {
    private final Integer LOTTO_NUMBER_INT;

    public LottoNumberValidator(Integer lottoNumString) {
        this.LOTTO_NUMBER_INT = Integer.valueOf(lottoNumString);

        validate();
    }
    public void validate() {
        isInt();
    }
    public void isInt() {
        if(!Rule.LottoNumberPattern.matcher(LOTTO_NUMBER_INT+"").matches()) {
            throw new IllegalArgumentException(Rule.NOTNUMBER_PATTERN);
        }
    }
}
