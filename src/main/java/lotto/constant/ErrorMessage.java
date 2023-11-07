package lotto.constant;

public enum ErrorMessage {
    NOT_CONTAINS_SIX_NUMBERS("입력된 숫자의 개수가 6개가 아닙니다."),
    INVALID_RANGE("잘못된 범위의 숫자가 있습니다."),
    NOT_POSITIVE_NUMBER("양수가 아닙니다."),
    PRICE_NOT_MULTIPLE_OF_THOUSAND("1000단위의 구입 금액이 아닙니다."),
    NOT_NUMERIC("숫자가 아닙니다."),
    HAVE_DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 동일할 수 없습니다."),
    HAVE_DUPLICATE_NUMBER("중복된 숫자가 있습니다.");
    private final String error;
    private static final String ERROR = "[ERROR] ";

    ErrorMessage(String error) {
        this.error = error;
    }

    public String getMessage() {
        return ERROR.concat(error);
    }
}
