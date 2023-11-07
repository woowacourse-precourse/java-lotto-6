package lotto.domain.validation;

public enum ExceptionMessage {
    EXCEPTION_MESSAGE_PREFIX("[ERROR]"),
    NUMBER_FORMAT_EXCEPTION("1000원 단위의 숫자를 입력해 주세요. 최소 금액은 1000원 입니다."),
    BONUS_NUMBER_FORMAT_EXCEPTION("1~45범위의 숫자를 입력해 주세요."),
    BONUS_NUMBER_DUPLICATES_EXCEPTION("보너스 번호는 당첨 번호와 서로 달라야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
