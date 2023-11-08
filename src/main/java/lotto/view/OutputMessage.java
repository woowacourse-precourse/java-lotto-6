package lotto.view;

public enum OutputMessage {
    THREE_MATCHES("3개 일치 (5,000원) - "),
    FOUR_MATCHES("4개 일치 (50,000원) - "),
    FIVE_MATCHES("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - "),
    WINNING_STATISTICS("당첨 통계"),
    BOUGHT_LOTTO("개를 구매했습니다.");

    private String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
