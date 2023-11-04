package lotto.domain;

import java.util.List;

public class OutputLottoResult {
    private int match3;
    private int match4;
    private int match5;
    private int match5AndBonus;
    private int match6;

    public OutputLottoResult(List<LottoResult> lottoResults) {
        for (LottoResult lottoResult : lottoResults) {
            int returnCash = lottoResult.getReturnCash();

//            3개 일치 (5,000원) - 1개
//            4개 일치 (50,000원) - 0개
//            5개 일치 (1,500,000원) - 0개
//            5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//            6개 일치 (2,000,000,000원) - 0개

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
                case 200000000:
                    match6++;
                    break;
            }
        }
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
