package lotto.view;

import lotto.domain.model.Lotteries;
import lotto.domain.model.Lotto;
import lotto.enums.OutputMessage;

import java.util.List;

public final class OutputView {

    private OutputView() {
    }

    public static void showCountOfLotto(int countOfLotto) {
        String format = OutputMessage.OUTPUT_COUNT_OF_LOTTO_FORMAT.getMessage();

        System.out.println(String.format(format, countOfLotto));
    }

    public static void showLotteries(Lotteries lotteries) {
        for (Lotto lotto : lotteries.getLotteries()) {
            lotto.showNumbers();
        }
    }
}
