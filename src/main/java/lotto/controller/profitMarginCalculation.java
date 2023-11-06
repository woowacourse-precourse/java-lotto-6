package lotto.controller;

import lotto.lottoenum.LottoRanking;

import java.util.List;

public class profitMarginCalculation implements Calculation{
    @Override
    public float getCalculation(List<LottoRanking> lottoRankings) {
        float sum = 0;
        for(LottoRanking lottoRanking : lottoRankings){
            sum += lottoRanking.getPrice();
        }
        return sum / lottoRankings.size();
    }
}
