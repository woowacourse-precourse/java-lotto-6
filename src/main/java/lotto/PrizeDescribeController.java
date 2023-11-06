package lotto;

import domain.Calculator;
import domain.Lotto;
import domain.LottoBundle;
import domain.PrizeDescribe;
import domain.PrizeNumber;
import java.util.List;
import view.OutputView;

public class PrizeDescribeController {
    OutputView outputView = new OutputView();
    PrizeNumber prizeNumber = PrizeNumber.getInstance();
    Calculator calculator = new Calculator();
    LottoBundle lottoBundle = LottoBundle.getInstance();
    PrizeDescribe prizeDescribe = PrizeDescribe.getInstance();

    public void calculatePrizeDescribeLogic(int bonusNumber) {
        // 당첨 통계 계산
        createPrizeDescribe(prizeNumber.getPrizeNumber(), bonusNumber);
        // 줄바꿈하고 당첨 통계 출력
        outputView.lineBreak();
        outputView.printPrizeDescribe(prizeDescribe);
    }

    private void createPrizeDescribe(List<Integer> prizeNumber, int bonusNumber) {
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            calculator.calculatePrizeDescribe(lotto, prizeNumber, bonusNumber);
        }
    }
}
