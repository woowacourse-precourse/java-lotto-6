package lotto.model;

import java.util.regex.Pattern;

public class LottoAmountofMoney {
    private final Integer lottoAmountofMoney;
    private final String REGEX_DIGIT = "^[\\d]*$";
    private final String ERROR_MESSAGE = "[ERROR]";

    public LottoAmountofMoney(String lottoAmountofMoney) throws IllegalArgumentException {
        validate(lottoAmountofMoney);
        this.lottoAmountofMoney = Integer.parseInt(lottoAmountofMoney);
    }

    public Integer getLottoAmountofMoney() {
        return lottoAmountofMoney;
    }

    private void validate(String lottoAmountofMoney) {
        if (!Pattern.matches(REGEX_DIGIT, lottoAmountofMoney)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력에 숫자가 아닌 값이 들어왔습니다.");
        }
    }
}
