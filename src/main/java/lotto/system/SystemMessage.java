package lotto.system;

public enum SystemMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INPUT_ANTI_PATTERN_REGEX("[^0-9]+"),
    WINNING_NUMBER_SEPARATOR(","),
    OUTPUT_PURCHASED_LOTTOS("%d개를 구매했습니다.\n");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
