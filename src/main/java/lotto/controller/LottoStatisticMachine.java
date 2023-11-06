package lotto.controller;

import lotto.utils.PrizeType;

import java.util.Collections;
import java.util.List;

import static lotto.view.OutputView.printLottoStatistic;
import static lotto.view.OutputView.printLottoStatisticStartMessage;

public class LottoStatisticMachine {
    public static void drawStatistic(List<PrizeType> result) {
        printLottoStatisticStartMessage();
        for (PrizeType type : PrizeType.values()) {
            int frequency = Collections.frequency(result, type);
            printLottoStatistic(type, frequency);
        }
    }
}
