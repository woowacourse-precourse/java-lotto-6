package lotto;

import Converter.Converter;

public class TotalPrizeMoney {

    Integer totalPrizeMoney;

    private TotalPrizeMoney(Integer totalPrizeMoney){
        this.totalPrizeMoney = totalPrizeMoney;
    }

    public static TotalPrizeMoney findTotalPrizeMoney(LottoResultWinners lottoResultWinners){
        Integer sum = 0;
        for (Rank rank : Rank.values()) {
            if (lottoResultWinners.getNumberOfRankWinner(rank) == 0){
                continue;
            }
            sum += Integer.valueOf(Converter.commaStringToString(rank.getPrizeMoney()))
                    * lottoResultWinners.getNumberOfRankWinner(rank);
        }
        return new TotalPrizeMoney(sum);
    }

    public Integer getTotalPrizeMoney(){
        return totalPrizeMoney;
    }

    public Double getEarningRate(Integer money) {
        Double earningRate = Double.valueOf(totalPrizeMoney)  / Double.valueOf(money)  * 100;
        return Double.valueOf(Math.round(earningRate * 10)) / 10;
    }

}
