package lotto.controller;

import lotto.domain.EarningCalculator;
import lotto.values.EarningInformation;
import lotto.view.Output;
import lotto.vo.WinningResult;

import java.util.List;

public class WinningController {

    public WinningController(WinningResult result, int wastedMoney) {
        List<Integer> winning = result.getWinning();
        Output output = new Output();
        output.printResult();
        output.printWinning(winning);

        EarningCalculator calculator = new EarningCalculator(wastedMoney, sumEarning(winning));
        output.printEarnings(calculator.compute());
    }

    private double sumEarning(List<Integer> winning){
        double earnings = 0;
        for (int i = 0; i < winning.size(); i++) {
            int countWinning = winning.get(i);
            if (countWinning != 0) {
                earnings += (countWinning * EarningInformation.values()[i].getValue());
            }
        }
        return earnings;
    }
}
