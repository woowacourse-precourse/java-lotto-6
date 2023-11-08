package lotto.messages;

public enum LottoResultMessages {
    RESULT_MESSAGE_HEADER("당첨 통계"),
    RESULT_MESSAGE_SEPARATOR("---"),
    RESULT_MESSAGE_3_MATCH("3개 일치 (5,000원) - %d개"),
    RESULT_MESSAGE_4_MATCH("4개 일치 (50,000원) - %d개"),
    RESULT_MESSAGE_5_MATCH("5개 일치 (1,500,000원) - %d개"),
    RESULT_MESSAGE_5_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RESULT_MESSAGE_6_MATCH("6개 일치 (2,000,000,000원) - %d개"),
    RESULT_MESSAGE_TOTAL_INCOME("총 수익률은 %.1f%%입니다.");

    private final String message;

    LottoResultMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
