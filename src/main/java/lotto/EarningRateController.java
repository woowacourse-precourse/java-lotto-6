package lotto;

import domain.Calculator;
import view.OutputView;

public class EarningRateController {
    Calculator calculator = new Calculator();
    OutputView outputView = new OutputView();
    public void calculateEarningRateLogic(int money) {
        String earningRate = calculator.calculateEarningRate(money);
        // 총수익률 출력
        outputView.printEarningRate(earningRate);
    }
}
