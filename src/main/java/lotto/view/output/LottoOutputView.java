package lotto.view.output;

import static lotto.Constants.STATISTICS_HEADER;
import static lotto.Constants.TOTAL_YIELD_HEADER;
import static lotto.Constants.TOTAL_YIELD_TAIL;

public class LottoOutputView {
    public void printLotto(String lotto) {
        System.out.println(lotto);
    }

    public void printStatisticsHeader() {
        System.out.println(STATISTICS_HEADER);
    }

    public void printTotalYield(double yield) {
        System.out.println(TOTAL_YIELD_HEADER + yield + TOTAL_YIELD_TAIL);
    }
}
