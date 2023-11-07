package lotto.domain.Constant;

public enum InputViewMessage {
    SPLIT_DELIMETER(","),
    REGEX("[0-9]+"),
    INPUT_CASH("구입금액을 입력해 주세요."),
    INPUT_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요."),
    VALIDATE_CASH("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private String message;

    private InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
