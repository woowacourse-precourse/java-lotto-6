package lotto.enums;

public enum ExceptionMessages {
    INVALID_AMOUNT_MESSAGE("[ERROR] 잘못 입력된 구입 금액입니다. (1000원 단위로 입력해 주세요.)");
    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
