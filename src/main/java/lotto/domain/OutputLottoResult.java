package lotto.domain;

import lotto.domain.Constant.LottoCash;

import java.util.List;

public class OutputLottoResult {
    private int match3 = 0;
    private int match4 = 0;
    private int match5 = 0;
    private int match5AndBonus = 0;
    private int match6 = 0;

    private int totalReturnCash = 0;

    public OutputLottoResult(List<LottoResult> lottoResults) {
        for (LottoResult lottoResult : lottoResults) {
            int returnCash = lottoResult.getReturnCash();
            totalReturnCash += returnCash;

            if (returnCash == LottoCash.MATCH3.getCash())
                match3++;
            else if (returnCash == LottoCash.MATCH4.getCash())
                match4++;
            else if (returnCash == LottoCash.MATCH5.getCash())
                match5++;
            else if (returnCash == LottoCash.MATCH5ANDBONUS.getCash())
                match5AndBonus++;
            else if (returnCash == LottoCash.MATCH6.getCash())
                match6++;
        }
    }

    public int getTotalReturn() {
        return totalReturnCash;
    }

    public int getMatch3() {
        return this.match3;
    }

    public int getMatch4() {
        return match4;
    }

    public int getMatch5() {
        return match5;
    }

    public int getMatch5AndBonus() {
        return match5AndBonus;
    }

    public int getMatch6() {
        return match6;
    }
}
