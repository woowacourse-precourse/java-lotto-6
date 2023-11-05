package lotto.view;

import lotto.domain.model.Lotteries;
import lotto.message.OutputMessage;

public final class OutputView {

    private OutputView() {
    }

    public static void showCountOfLotto(int countOfLotto) {
        String format = OutputMessage.OUTPUT_COUNT_OF_LOTTO_FORMAT.getMessage();

        System.out.println(String.format(format, countOfLotto));
    }

    public static void showLotteries(Lotteries lotteries) {
        lotteries.showLotteries();
        System.out.println();
    }
}
