package lotto.validator;

public enum ExceptionMessages {
    NON_NUMERIC_INPUT("입력 값은 숫자이어야 합니다"),
    INVALID_INPUT("잘못된 입력값입니다."),
    OUT_OF_RANGE("숫자의 범위는 1에서 45까지만 입력해야 합니다."),
    INCORRECT_COUNT("6개를 입력해야 합니다"),
    DUPLICATE_NUMBERS("로또 번호는 중복된 값이 있을 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("금액은 1000원 단위로 입력해야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨번호와 중복될 수 없습니다.");

    private final String message;

    ExceptionMessages(String message) {
        String errorFormat = "[ERROR] %s";
        this.message = String.format(errorFormat, message);
    }

    public String getErrorMessage() {
        return message;
    }
}
