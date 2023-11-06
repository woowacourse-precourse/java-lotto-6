package lotto.domain;

public enum WinningRate {
    FIRST(6,2000000000,"6개 일치 (2,000,000,000원) - "),
    SECOND(7,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5,1500000,"5개 일치 (1,500,000원) - "),
    FOURTH(4,50000, "4개 일치 (50,000원) - "),
    FIFTH(3,5000, "3개 일치 (5,000원) - "),
    LOSE(0,0,"");

    private int correctNumber;
    private long rateOfReturn;
    private String message;

    WinningRate(int correctNumber, long rateOfReturn, String message) {
        this.correctNumber = correctNumber;
        this.rateOfReturn = rateOfReturn;
        this.message = message;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public long getRateOfReturn() {
        return rateOfReturn;
    }

    public String getMessage() {
        return message;
    }
}
