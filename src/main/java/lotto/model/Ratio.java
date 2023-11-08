package lotto.model;

import java.util.Arrays;

public class Ratio {
    private final double ratio;
    private int allMoney = 0;

    public Ratio(int money, LottoResult lottoResult) {
        calculateWinnig(lottoResult);
        this.ratio = Math.round(((double) allMoney / money)*1000)/ 10.0;
    }

    private void calculateWinnig(LottoResult lottoResult){
        Arrays.stream(LottoRank.values())
                .forEach(lotto -> addMoney(lottoResult.getRankCount(lotto), lotto.getWinning()));
    }

    private void addMoney(int winning, int count ){
        allMoney += winning*count;
    }

    public double getRatio() {
        return ratio;
    }
}
