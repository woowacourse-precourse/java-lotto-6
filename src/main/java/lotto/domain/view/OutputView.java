package lotto.domain.view;

import static lotto.domain.view.OutputViewFormat.GUIDE_RATE_FORMAT;
import static lotto.domain.view.OutputViewFormat.GUIDE_RESULT_FORMAT;
import static lotto.domain.view.OutputViewFormat.GUIDE_STATICS;

public final class OutputView {
    public static void printLottos(String lottosStatus) {
        System.out.println(lottosStatus);
    }

    public static void printLottoAmount(Integer ticketCount) {
        System.out.printf((OutputViewFormat.GUIDE_LOTTO_AMOUNT_FORMAT.getState()) + "%n", ticketCount);
    }

    public static void printStatics() {
        System.out.println(GUIDE_STATICS);
    }

    public static void printReturnOnInvestment(Double returnOnInvestment) {
        System.out.printf((GUIDE_RATE_FORMAT.state) + "%n", returnOnInvestment);
    }

    public static void printEachResult(String state, int count) {
        System.out.printf((GUIDE_RESULT_FORMAT.state) + "%n", state, count);
    }
}
