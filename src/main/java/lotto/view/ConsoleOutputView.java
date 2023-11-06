package lotto.view;

import static lotto.configuration.OutputMessages.PURCHASE_COUNT_MESSAGE;
import static lotto.configuration.OutputMessages.THREE_DIVIDING_LINES_MESSAGE;
import static lotto.configuration.OutputMessages.WINNING_STATISTICS_MESSAGE;

import java.util.List;
import lotto.domain.Rankings;
import lotto.util.OutputUtil;

public class ConsoleOutputView implements OutputView {

    @Override
    public void outputPurchaseLottoList(List<String> purchaseLottoList) {
        System.out.println(purchaseLottoList.size() + PURCHASE_COUNT_MESSAGE.getMessage());
        purchaseLottoList.stream()
                        .forEach(System.out::println);

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputWinningStatistics(Rankings rankings) {
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(THREE_DIVIDING_LINES_MESSAGE.getMessage());

        //TODO: 구현
    }
}
