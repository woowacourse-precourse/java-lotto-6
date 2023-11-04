package lotto.domain;

import lotto.utility.ErrorMessage;

// 입력하는 구입금액
public class Purchase {
    private final int amount;
    private final String MATCH_NUMBER = "\\d+";

    public Purchase(int amount) {
        validateNumber(amount);
        validateThousandUnit(amount);
        this.amount = amount;
    }

    // 구입 금액 숫자인지 검증
    private void validateNumber(int number) {
        if (!isNumeric(String.valueOf(number))) {
            throw new IllegalArgumentException("구입금액 에러");
        }
    }

    private boolean isNumeric(String str) {
        return str.matches(MATCH_NUMBER);
    }

    // 구입 금액 1000원 단위인지 검증
    private void validateThousandUnit(int number) {
        if (number <= 0 && number % 1000 != 0) {
            throw new IllegalArgumentException("단위 외 에러");
        }
    }
}
