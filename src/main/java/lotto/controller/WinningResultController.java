package lotto.controller;

import lotto.domain.WinningResult;

import java.util.Map;

import static lotto.view.OutputView.printEmptyLine;
import static lotto.view.OutputView.printLottoStatistics;

public class WinningResultController {

    public static void printWinningResult(Map<WinningResult, Integer> result, float calculateRateOfReturn) {
        printEmptyLine();
        printLottoStatistics(result, calculateRateOfReturn);
    }
}
