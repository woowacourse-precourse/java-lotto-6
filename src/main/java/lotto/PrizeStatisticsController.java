package lotto;

import domain.Calculator;
import domain.Lotto;
import domain.LottoBundle;
import domain.PrizeStatistics;
import java.util.List;
import view.OutputView;

public class PrizeStatisticsController {
    OutputView outputView = new OutputView();
    Calculator calculator = new Calculator();
    PrizeStatistics prizeDescribe = PrizeStatistics.getInstance();

    public void calculatePrizeDescribeLogic(LottoBundle lottoBundle, List<Integer> prizeNumber, int bonusNumber) {
        // 당첨 통계 계산
        createPrizeDescribe(lottoBundle, prizeNumber, bonusNumber);
        // 줄바꿈하고 당첨 통계 출력
        outputView.lineBreak();
        outputView.printPrizeDescribe(prizeDescribe);
    }

    private void createPrizeDescribe(LottoBundle lottoBundle, List<Integer> prizeNumber, int bonusNumber) {
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            calculator.calculatePrizeDescribe(lotto, prizeNumber, bonusNumber);
        }
    }
}
