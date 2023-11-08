package lotto.view;

import lotto.model.Lotto;
import lotto.service.LottoPrize;

import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class OutputView {

    public void askPurchaseAmount() {
        System.out.println(ViewMessages.ASK_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    private static final int DIVIDER_COUNT = 3;

    public void showPurchasedLottoTicketsNumber(int ticketNumber) {
        System.out.println();
        System.out.println(ViewMessages.PURCHASE_SUCCESS.getCountMessage(ticketNumber));
    }

    public void showPurchasedLottoTickets(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getAscendingSortedNumbers();
            StringJoiner joiner = new StringJoiner(", ", "[", "]");
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

    public void showLottoResult(HashMap<LottoPrize, Integer> resultMap) {
        System.out.println();
        System.out.println(ViewMessages.LOTTO_RESULT_TITLE.getMessage());
        IntStream.range(0, DIVIDER_COUNT).forEach(i -> System.out.print(ViewMessages.DIVIDER.getMessage()));
        System.out.println();
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize != LottoPrize.NOTHING_MATCH) {
                int count = resultMap.getOrDefault(prize, 0);
                String resultMessage = String.format("%s - %d개", prize.getFormat(), count);
                System.out.println(resultMessage);
            }
        }
    }

    public void showProfitRate(Double profitRate) {
        String formattedProfitRate = String.format("%.1f%%", profitRate);
        System.out.println("총 수익률은 " + formattedProfitRate + "입니다.");
    }
}
