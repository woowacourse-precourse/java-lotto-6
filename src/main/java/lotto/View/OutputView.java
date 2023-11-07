package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Ranking;

import java.util.Map;

public class OutputView {
    public void outputLottoNum(Lotto lotto) {
        lotto.outputLottoNum();
    }

    public void outputResult(Map<Ranking, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i = Ranking.values().length -1; i>=0; i--) {
            Ranking.values()[i].outputMessage(result.get(Ranking.values()[i]));
        }
    }

    public void outputRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) +"%입니다.");
    }
}
