package lotto.enums;

public enum MatchCountMessage {
    PRIZE_5TH("3개 일치 (5,000원) - "),
    PRIZE_4TH("4개 일치 (50,000원) - "),
    PRIZE_3RD("5개 일치 (1,500,000원) - "),
    PRIZE_2ND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRIZE_1ST("6개 일치 (2,000,000,000원) - ");

    private final String message;

    MatchCountMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
