package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoConstants;
import lotto.service.LottoPrizeMessage;

import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class OutputView {

    public void askPurchaseAmount() {
        System.out.println(ViewMessages.ASK_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void showPurchasedLottoTicketsNumber(int ticketNumber) {
        System.out.println();
        System.out.println(ViewMessages.PURCHASE_SUCCESS.getCountMessage(ticketNumber));
    }

    public void showPurchasedLottoTickets(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getAscendingSortedNumbers();
            StringJoiner joiner = new StringJoiner(ViewMessages.DELIMITER.getMessage(), ViewMessages.PREFIX.getMessage(), ViewMessages.SUFFIX.getMessage());
            numbers.forEach(number -> joiner.add(String.valueOf(number)));
            System.out.println(joiner);
        }
    }

    public void askWinningNumbers() {
        System.out.println();
        System.out.println(ViewMessages.ASK_WINNING_NUMBERS_MESSAGE.getMessage());
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println(ViewMessages.ASK_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void showLottoResult(HashMap<LottoPrizeMessage, Integer> resultMap) {
        System.out.println();
        System.out.println(ViewMessages.LOTTO_RESULT_TITLE.getMessage());
        IntStream.range(0, LottoConstants.DIVIDER_COUNT).forEach(i -> System.out.print(ViewMessages.DIVIDER.getMessage()));
        System.out.println();
        for (LottoPrizeMessage prize : LottoPrizeMessage.values()) {
            if (prize != LottoPrizeMessage.NOTHING_MATCH) {
                int count = resultMap.getOrDefault(prize, 0);
                String resultMessage = String.format(ViewMessages.PRIZE_COUNT_FORMAT.getMessage(), prize.getFormat(), count);
                System.out.println(resultMessage);
            }
        }
    }

    public void showProfitRate(Double profitRate) {
        String formattedProfitRate = String.format(ViewMessages.PROFIT_FORMAT.getMessage(), profitRate);
        System.out.println(String.format(ViewMessages.PROFIT_MESSAGE.getMessage(),formattedProfitRate));
    }
}
