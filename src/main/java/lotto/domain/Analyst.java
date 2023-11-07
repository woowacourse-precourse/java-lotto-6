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
        if (winningCount==3) {
            prize = LottoRank.RANK5.getPrize();
        } else if (winningCount==4) {
            prize = LottoRank.RANK4.getPrize();
        } else if (winningCount==5) {
            if (bonusCount==false) {
                prize = LottoRank.RANK3.getPrize();
            } else {
                prize = LottoRank.RANK2.getPrize();
            }
        } else if (winningCount==6) {
            prize = LottoRank.RANK1.getPrize();
        }
        totalIncome += prize;
    }

    public float revenueLotto() {
        float result = totalIncome/(lottoSize*LottoRole.LOTTO_PRICE.getNumber());
        return result;
    }
}
