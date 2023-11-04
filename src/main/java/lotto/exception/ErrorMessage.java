package lotto.exception;

public enum ErrorMessage {
    INVALID_INPUT_NOT_NUMERIC("[ERROR] 숫자를 입력해주세요."),

    //구입금액
    PURCHASE_AMOUNT_NEGATIVE("[ERROR] 1000 단위의 양수를 입력해주세요."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE("[ERROR] 1000 으로 나누어 떨어지는 수를 입력해주세요"),

    //로또 번호
    INPUT_INVALID_RANGE("[ERROR] 1 이상 45 이하의 숫자를 입력해주세요."),
    LOTTO_NUMBERS_DUPLICATED("[ERROR] 서로 다른 6개 숫자만 가능합니다."),
    LOTTO_NUMBERS_INVALID_SIZE("[ERROR] 로또 숫자는 6개만 가능합니다."),
    WINNING_NUMBERS_BLANK("[ERROR] 당첨번호 6개를 입력해주세요."),
    WINNING_NUMBERS_STARTS_OR_ENDS_WITH_DELIMITER("[ERROR] 당첨번호 6개를 쉼표로 구분하여 입력해주세요."),
    WINNING_NUMBERS_NOT_NUMERIC("[ERROR] 당첨번호로 6개의 숫자를 입력해주세요."),
    BONUS_NUMBER_DUPLICATED("[ERROR] 보너스 넘버는 당첨번호와 중복되지 않는 숫자로 입력해주세요.");

    private String message;

    ErrorMessage(String s) {
    }

    public String getMessage() {
        return message;
    }
}
