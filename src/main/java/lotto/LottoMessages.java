package lotto;

public enum LottoMessages {
    INPUT_USER_LOTTO_PURCHASE("구입금액을 입력해 주세요."),
    INPUT_USER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_USER_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    COMPLETE_MESSAGE_LOTTO_COST("%d개를 구매했습니다.\n"),

    RESULT_MESSAGE_HEADER("당첨 통계"),
    RESULT_MESSAGE_SEPARATOR("---"),
    RESULT_MESSAGE_3_MATCH("3개 일치 (5,000원) - %d개\n"),
    RESULT_MESSAGE_4_MATCH("4개 일치 (50,000원) - %d개\n"),
    RESULT_MESSAGE_5_MATCH("5개 일치 (1,500,000원) - %d개\n"),
    RESULT_MESSAGE_5_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    RESULT_MESSAGE_6_MATCH("6개 일치 (2,000,000,000원) - %d개\n"),
    RESULT_MESSAGE_TOTAL_INCOME("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    LottoMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
