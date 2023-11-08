package lotto.controller;

import lotto.model.Deposit;
import lotto.utils.PrizeType;

import java.util.Collections;
import java.util.List;

import static lotto.view.OutputView.*;

public class LottoStatisticMachine {
    public static void drawStatistic(List<PrizeType> result, Deposit deposit) {
        printLottoStatisticStartMessage();

        int earnings = 0;
        for (PrizeType type : PrizeType.values()) {
            int frequency = Collections.frequency(result, type);
            earnings += frequency * type.getPrizeMoney();
            printLottoStatistic(type.getDescription(), frequency);
        }

        printEarningsRate(deposit.calculateEarningsRate(earnings));
    }
}
