package lotto.domain;

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

            switch (returnCash) {
                case 5000:
                    match3++;
                    break;
                case 50000:
                    match4++;
                    break;
                case 1500000:
                    match5++;
                    break;
                case 30000000:
                    match5AndBonus++;
                    break;
                case 2000000000:
                    match6++;
                    break;
            }
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
