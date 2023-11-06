package lotto.message;

public enum Message {
    WINNING_STATISTICS("당첨 통계"),
    SEPARATOR("---"),
    THREE_MATCHES("3개 일치 (5,000원) - "),
    FOUR_MATCHES("4개 일치 (50,000원) - "),
    FIVE_MATCHES("5개 일치 (1,500,000원) - "),
    FIVE_MATCHES_BOUNS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - "),
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
