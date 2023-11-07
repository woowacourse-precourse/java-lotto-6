package lotto;

import model.Calculator;
import view.OutputView;

public class EarningRateController {
    Calculator calculator = new Calculator();
    OutputView outputView = new OutputView();

    public void calculateEarningRateProcess(int money) {
        // 구입 금액을 입력받아 총 수익률 계산
        String earningRate = calculator.calculateEarningRate(money);
        // 총수익률 출력
        outputView.printEarningRate(earningRate);
    }
}
