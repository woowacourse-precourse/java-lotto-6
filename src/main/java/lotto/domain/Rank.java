package lotto.domain;

public enum Rank {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FORTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000);

    private final String agreementNumber;
    private final int prizeMoney;

    private Rank(String agreementNumber, int prizeMoney) {
        this.agreementNumber = agreementNumber;
        this.prizeMoney= prizeMoney;
    }

    public String getAgreementNumber() {
        return agreementNumber ;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
