package lotto.view;

import java.util.List;
import lotto.model.Referee;
import lotto.model.Lotto;
import lotto.utils.Constants;

public class OutputView {
    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public static void printLottoSize(final List<Lotto> lottos) {
        System.out.printf(Constants.PURCHASE_COUNT_MESSAGE, lottos.size());
    }

    public void printResult(final Referee referee, final double rateOfReturn) {
        System.out.println(referee);
        System.out.printf(Constants.RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}