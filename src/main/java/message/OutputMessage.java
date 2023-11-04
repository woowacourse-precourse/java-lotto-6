package message;

public enum OutputMessage {

    RESULT("당첨 통계\n---"),
    ISSUED_LOTTO_COUNT("%s개를 구매했습니다."),
    THREE_NUMBERS_MATCHES("3개 일치 (5,000원) - %s개"),
    FOUR_NUMBERS_MATCHES("4개 일치 (50,000원) - %s개"),
    FIVE_NUMBERS_MATCHES("5개 일치 (1,500,000원) - %s개"),
    FIVE_AND_BONUS_NUMBERS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
    SIX_NUMBERS_MATCHES("6개 일치 (2,000,000,000원) - %s개"),
    TOTAL_RETURN("총 수익률은 %s%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public void print(String value) {
        System.out.printf(message, value);
    }
}
