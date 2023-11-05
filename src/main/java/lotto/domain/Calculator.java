package lotto.domain;

import java.util.List;

public class Calculator {
    public float rateOFProfit(List<Integer> result, int lottoCount) {
        int pay = calculatePayAmount(lottoCount);
        int income = calculateProfit(result);
        return (float) income / pay * 100;
    }

    public int calculatePayAmount(int lottoCount) {
        return lottoCount * Lotto.PRICE;
    }

    public int calculateProfit(List<Integer> result) {
        int income = 0;
        int index = 0;
        for (Prize prize : Prize.values()) {
            income += result.get(index++) * prize.getPrizeMoney();
        }
        return income;
    }
}
