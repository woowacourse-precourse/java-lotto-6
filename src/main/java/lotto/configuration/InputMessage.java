package lotto.configuration;

public enum InputMessage {
    BUY_LOTTO_COUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getInputMessage() {
        return message;
    }
}
