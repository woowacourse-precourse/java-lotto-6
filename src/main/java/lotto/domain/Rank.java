package lotto.domain;

public enum Rank {
    NO("0개 일치 - ",false),
    FIFTH("3개 일치 (5,000원) - ",false),
    FOURTH("4개 일치 (50,000원) - ",false),
    THIRD("5개 일치 (1,500,000원) - ",false),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",true),
    FIRST("6개 일치 (2,000,000,000원) - ",false);
    private final String message;
    private final boolean bonusCheck;

    Rank(final String message, final boolean bonusCheck) {
        this.message = message;
        this.bonusCheck = bonusCheck;
    }
}
