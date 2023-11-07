package lotto.constant;

public enum ErrorMessage {
    PROMPT_EXCEPTION_SIZE(" 로또 번호는 " + Constant.NUMBERS_SIZE + "개여야 합니다."),
    PROMPT_EXCEPTION_OUT_OF_RANGE(
            " 로또 번호는 " + Constant.MIN_NUMBER + "~" + Constant.MAX_NUMBER + " 사이의 수여야 합니다."),
    PROMPT_EXCEPTION_DUPLICATE(" 로또 번호는 서로 다른 수여야 합니다.");

    public final String prefix = "[ERROR]";
    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
