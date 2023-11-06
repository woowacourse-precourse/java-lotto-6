package lotto.util.constants;

public enum InputConstants {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNER_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputConstants(String message) {
        this.message = message;
    }

    public String getConstants() {
        return message;
    }
}
