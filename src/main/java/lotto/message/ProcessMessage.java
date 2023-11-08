package lotto.message;

public enum ProcessMessage {
    INPUT_MONEY_TO_BUY_LOTTO("구입금액을 입력해 주세요."),
    LOTTO_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
