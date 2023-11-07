package lotto;

import model.Calculator;
import model.PrizeStatistics;
import java.util.List;
import view.OutputView;

public class PrizeStatisticsController {
    OutputView outputView = new OutputView();
    Calculator calculator = new Calculator();
    PrizeStatistics prizeStatistics = PrizeStatistics.getInstance();

    public void calculatePrizeStatisticsProcess(List<Integer> prizeNumber, int bonusNumber) {
        // 당첨 통계 계산
        calculator.calculatePrizeStatistics(prizeNumber, bonusNumber);
        // 줄바꿈하고 당첨 통계 출력
        outputView.lineBreak();
        outputView.printPrizeDescribe(prizeStatistics);
    }
}
