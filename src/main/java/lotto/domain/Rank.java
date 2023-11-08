package lotto.domain;

public enum Rank {
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000,0),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000,0),
    THIRD("5개 일치 (1,500,000원) - ", 1500000,0),
    FORTH("4개 일치 (50,000원) - ", 50000,0),
    FIFTH("3개 일치 (5,000원) - ", 5000,0);

    private final String agreementNumber;
    private final int prizeMoney;
    private int number;

    private Rank(String agreementNumber, int prizeMoney, int number) {
        this.agreementNumber = agreementNumber;
        this.prizeMoney = prizeMoney;
        this.number = number;
    }

    public String getAgreementNumber() {
        return agreementNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public void setNumber(int number){
        this.number = this.number + number;
    }

    public int getNumber(){
        return this.number;
    }


}
