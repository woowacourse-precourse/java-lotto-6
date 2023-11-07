package lotto.constants;

public enum Error {
    ERROR_HEADER("[ERROR]"),
    INVALID_AMOUNT(
            ERROR_HEADER.message + " " +
                    NumberRule.LOTTO_PRICE.getNumber() + "원 단위 이상, 10만원 이하의 금액을 입력하세요."
    ),
    INVALID_FIRST_RANK_NUMBERS(
            ERROR_HEADER.message + " " +
                    "중복되지 않는 " + NumberRule.MIN_LOTTO_NUMBER.getNumber() + "이상 " +
                    NumberRule.MAX_LOTTO_NUMBER.getNumber() + "이하의 수 " +
                    NumberRule.COUNT_OF_LOTTO_NUMBERS.getNumber() + "개를 입력하세요."
                    + "(각 번호는 쉼표(,)로 구분합니다.)"
    ),
    INVALID_BONUS_NUMBER(
            ERROR_HEADER.message + " " +
                    "당첨번호와 중복되지 않는 " +
                    NumberRule.MIN_LOTTO_NUMBER.getNumber() + "이상 " +
                    NumberRule.MAX_LOTTO_NUMBER.getNumber() + "이하의 수를 입력하세요."
    );

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
