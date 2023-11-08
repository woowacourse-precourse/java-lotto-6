package lotto.constants;

public enum GameMessage {
    PAY_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PAY_OUTPUT_MESSAGE("\n%d개를 구매했습니다."),
    WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    STATISTICS_MESSAGE("\n당첨 통계"),
    FIRST_PRIZE_MESSAGE("6개 일치 (2,000,000,000원) - %d개"),
    SECOND_PRIZE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_PRIZE_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    FORTH_PRIZE_MESSAGE("4개 일치 (50,000원) - %d개"),
    FIFTH_PRIZE_MESSAGE("3개 일치 (5,000원) - %d개"),
    RESULT_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
