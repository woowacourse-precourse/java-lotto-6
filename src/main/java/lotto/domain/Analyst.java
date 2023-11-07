package lotto.domain;

public class Analyst {
    private final int lottoSize;
    private int totalIncome;

    public Analyst(int lottoSize) {
        this.lottoSize = lottoSize;
        this.totalIncome = 0;
    }

    public void addLottoResult(int winningCount, boolean bonusCount) {
        int prize = 0;
        if (winningCount == 3) {
            prize = LottoRank.RANK5.getPrize();
            LottoRank.RANK5.increaseCount();
        } else if (winningCount == 4) {
            if (!bonusCount) {
                prize = LottoRank.RANK4.getPrize();
                LottoRank.RANK4.increaseCount();
            } else if (bonusCount) {
                prize = LottoRank.RANK3.getPrize();
                LottoRank.RANK3.increaseCount();
            }
        } else if (winningCount == 5) {
            prize = LottoRank.RANK2.getPrize();
            LottoRank.RANK2.increaseCount();
        } else if (winningCount == 6) {
            prize = LottoRank.RANK1.getPrize();
            LottoRank.RANK1.increaseCount();
        }
        totalIncome += prize;
    }

    public double revenueLotto() {
        double result = ((double)totalIncome / (double)(lottoSize * LottoRole.LOTTO_PRICE.getNumber())) * 100;
        return result;
    }
}
