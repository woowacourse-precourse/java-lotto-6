package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.WinningResult;

import java.util.List;

import static lotto.constant.MessageConstant.*;
import static lotto.constant.SymbolConstant.NEW_LINE;
import static lotto.constant.SymbolConstant.QUANTITY_UNIT;

public class MessagePrinter {

    public void printBuyingPriceMessage() {
        System.out.println(BUYING_PRICE_MESSAGE);
    }

    public void printBuyingAmountMessage(final LottoGame lottoGame) {
        int buyingAmount = lottoGame.getBuyingAmount();
        System.out.println(NEW_LINE + buyingAmount + BUYING_AMOUNT_MESSAGE);
    }

    public void printLottoNumbers(final LottoGame lottoGame) {
        List<Lotto> lottos = lottoGame.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }

    public void printWinningNumbersMessage() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBERS_MESSAGE);
    }

    public void printWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    public void printWinningStatisticsResult(final WinningResult winningResult) {
        System.out.println(FIFTH_PRIZE_STATISTICS_MESSAGE + winningResult.getRank5() + QUANTITY_UNIT);
        System.out.println(FOURTH_PRIZE_STATISTICS_MESSAGE + winningResult.getRank4() + QUANTITY_UNIT);
        System.out.println(THIRD_PRIZE_STATISTICS_MESSAGE + winningResult.getRank3() + QUANTITY_UNIT);
        System.out.println(SECOND_PRIZE_STATISTICS_MESSAGE + winningResult.getRank2() + QUANTITY_UNIT);
        System.out.println(FIRST_PRIZE_STATISTICS_MESSAGE + winningResult.getRank1() + QUANTITY_UNIT);
    }

    public void printEarningsRate(final WinningResult winningResult, final LottoGame lottoGame) {
        double earningsRate = winningResult.calculateEarningsRate(lottoGame);
        String formattedText = String.format(EARNINGS_RATE_RESULT, earningsRate);
        System.out.println(formattedText);
    }
}
