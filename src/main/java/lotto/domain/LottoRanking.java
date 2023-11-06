package lotto.domain;

public enum LottoRanking {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FORTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)");

    private final Integer countLottoMatched;
    private final Integer winningMoney;
    private final String winningMessage;

    LottoRanking(Integer countLottoMatched, Integer winningMoney, String winningMessage){
        this.countLottoMatched = countLottoMatched;
        this.winningMoney = winningMoney;
        this.winningMessage = winningMessage;
    }

    public Integer getCountLottoMatched() {
        return countLottoMatched;
    }

    public Integer getWinningMoney() {
        return winningMoney;
    }

    public String getWinningMessage() {
        return winningMessage;
    }
}
