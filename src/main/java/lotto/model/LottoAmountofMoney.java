package lotto.model;

import static lotto.constant.ErrorMessage.ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.INPUTCONTAINNOTNUMBER;
import static lotto.constant.Format.REGEX_DIGIT;

import java.util.regex.Pattern;

public class LottoAmountofMoney {
    private final Integer lottoAmountofMoney;

    public LottoAmountofMoney(String lottoAmountofMoney) throws IllegalArgumentException {
        validate(lottoAmountofMoney);
        this.lottoAmountofMoney = Integer.parseInt(lottoAmountofMoney);
    }

    public Integer getLottoAmountofMoney() {
        return lottoAmountofMoney;
    }

    private void validate(String lottoAmountofMoney) {
        if (!Pattern.matches(REGEX_DIGIT.getValue(), lottoAmountofMoney)) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + INPUTCONTAINNOTNUMBER.getValue());
        }
    }
}
