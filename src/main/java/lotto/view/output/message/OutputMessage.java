package lotto.view.output.message;

public enum OutputMessage {

    READ_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    READ_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    READ_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    PRINT_PURCHASED_LOTTOS_MESSAGE("%d개를 구매했습니다."),
    PRINT_ANALYSIS_FORMAT(
            """
            당첨 통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            총 수익률은 %.1f%%입니다.
            """
    );

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
