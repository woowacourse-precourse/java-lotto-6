package lotto.Controller;

import static lotto.View.OutputView.PrintRateReturn.printRateReturn;
import static lotto.View.OutputView.PrintResult.printResult;

import java.util.List;
import lotto.Model.RateReturn;

public class ResultController {

    private final RateReturn rateReturn;

    public ResultController(List<Integer> winsCount,int countLotto) {
        printResult(winsCount);

        rateReturn = new RateReturn(winsCount,countLotto);
        printRateReturn(rateReturn.getRateReturn());
    }

}
