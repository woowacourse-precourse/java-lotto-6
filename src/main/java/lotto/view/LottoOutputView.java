package lotto.view;

import static lotto.view.constant.ViewConstant.OutputViewConstant.AMOUNT;
import static lotto.view.constant.ViewConstant.OutputViewConstant.BONUS_NUMBER_MESSAGE;
import static lotto.view.constant.ViewConstant.OutputViewConstant.EARNING_RATE_MESSAGE;
import static lotto.view.constant.ViewConstant.OutputViewConstant.FIVE_AND_BONUS_MATCHED;
import static lotto.view.constant.ViewConstant.OutputViewConstant.FIVE_MATCHED;
import static lotto.view.constant.ViewConstant.OutputViewConstant.FOUR_MATCHED;
import static lotto.view.constant.ViewConstant.OutputViewConstant.NEW_LINE;
import static lotto.view.constant.ViewConstant.OutputViewConstant.PURCHASE_AMOUNT_MESSAGE;
import static lotto.view.constant.ViewConstant.OutputViewConstant.PURCHASE_MESSAGE;
import static lotto.view.constant.ViewConstant.OutputViewConstant.SIX_MATCHED;
import static lotto.view.constant.ViewConstant.OutputViewConstant.START_INDEX;
import static lotto.view.constant.ViewConstant.OutputViewConstant.STATUS;
import static lotto.view.constant.ViewConstant.OutputViewConstant.THREE_DASH;
import static lotto.view.constant.ViewConstant.OutputViewConstant.THREE_MATCHED;
import static lotto.view.constant.ViewConstant.OutputViewConstant.WINNING_NUMBER;
import static lotto.view.constant.ViewConstant.OutputViewConstant.WINNING_NUMBER_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoOutputView {
    public void printErrorMessage(final String message) {
        System.out.println(message);
        printNewLine();
    }

    public void printNewLine() {
        System.out.println();
    }

    public void request(String order) {
        if (AMOUNT.equals(order)) {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            return;
        }
        if (WINNING_NUMBER.equals(order)) {
            System.out.println(WINNING_NUMBER_MESSAGE);
            return;
        }
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printUserLotto(final Long lottoCount, final String lotto) {
        System.out.printf(PURCHASE_MESSAGE + NEW_LINE, lottoCount);
        System.out.println(lotto);
        printNewLine();
    }

    public void printStatistics(final List<Long> winCounts) {
        System.out.println(STATUS);
        System.out.println(THREE_DASH);
        System.out.println(supplyStatistics(winCounts));
    }

    public void printEarningRate(final double earningRate) {
        System.out.printf(EARNING_RATE_MESSAGE + NEW_LINE, earningRate);
    }

    public String supplyStatistics(List<Long> winCounts) {
        List<String> prizeMessages = List.of(
                THREE_MATCHED,
                FOUR_MATCHED,
                FIVE_MATCHED,
                FIVE_AND_BONUS_MATCHED,
                SIX_MATCHED
        );

        return IntStream.range(START_INDEX, winCounts.size())
                .mapToObj(index -> String.format(prizeMessages.get(index), winCounts.get(index)))
                .collect(Collectors.joining(NEW_LINE));
    }
}
