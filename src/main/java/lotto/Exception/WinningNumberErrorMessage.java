package lotto.Exception;

public enum WinningNumberErrorMessage {
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1~45 숫자만 입력이 가능합니다."),
    NO_WINNING_NUMBER_ENTERED("[ERROR] 당첨 번호를 입력해 주세요."),
    TOO_MANY_WINNING_NUMBERS("[ERROR] 당첨 숫자는 6개만 입력해 주세요."),
    INVALID_WINNING_NUMBER_FORMAT("[ERROR] 당첨 번호는 쉼표(,)를 이용해서 구분해 주세요. 또한 쉼표 뒤에 공백이 있어서는 안 됩니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 중복된 당첨 번호를 입력할 수는 없습니다.");

    private final String message;

    WinningNumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
