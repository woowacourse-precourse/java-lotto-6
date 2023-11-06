package lotto.validate;

import java.util.Objects;

public class InputValidation {
    private final String NUMBER_REG_EXP = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
    private final String ONLY_1_45_NUMBER = "1-45 사이의 숫자만 입력하세요.";
    private final String ONLY_DIVIDED_THOUSAND = "금액은 1000단위로 입력하세요.";
    // 구입금액 validation

    // 0-45 숫자 이외의 값이 있는지
    public void isNumber(String number) {
        if (!number.matches(NUMBER_REG_EXP)) {
            throw new IllegalArgumentException(ONLY_1_45_NUMBER);
        }
    }

}
