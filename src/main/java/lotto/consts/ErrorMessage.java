package lotto.consts;

public enum ErrorMessage {
    ERROR_MESSAGE_INPUT_MUST_BE_NUMBER("숫자로 입력해주세요."),
    ERROR_MESSAGE_AMOUNT_UNIT("로또 1장의 가격은 1,000원 입니다."),
    ERROR_MESSAGE_BUY_MORE_THAN_ONE("로또 1장 이상은 구매하셔야 합니다."),
    ERROR_MESSAGE_NOT_ENOUGH_LOTTO_NUMBER("로또 번호를 6개 입력해야 합니다."),
    ERROR_MESSAGE_DUPLICATED_EXISTENCE("로또 번호를 중복 없이 입력해주세요."),
    ERROR_MESSAGE_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    private final String message;
    private final String defaultMessage = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return defaultMessage + message;
    }
}
