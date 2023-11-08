package lotto.utils;

public enum GameMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PURCHASE_MESSAGE("개를 구매했습니다."),
    RESULT_MESSAGE("\n당첨 통계"),
    SEPARATOR("---"),
    LOTTO_RESULT_MESSAGE("%s (%,d원) - %d개%n"),
    PROFIT_MESSAGE("총 수익률은 %.1f%%입니다.");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
