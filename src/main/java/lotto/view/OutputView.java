package lotto.view;

import lotto.domain.winning.LottoWinningRanking;
import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class OutputView {
    public void requestPurchaseAmount() {
        display(OutputMessage.REQUEST_PURCHASE_AMOUNT);
    }

    public void requestWinningNumbers() {
        display(OutputMessage.REQUEST_WINNING_NUMBERS);
    }

    public void requestBonusNumber() {
        display(OutputMessage.REQUEST_BONUS_NUMBER);
    }

    public void responsePurchaseCount(final int count) {
        display(OutputMessage.RESPONSE_PURCHASE_COUNT, count);
    }

    public void responseUserNumbersSet(final List<LottoDto> lottos) {
        for (LottoDto lotto : lottos) {
            display(OutputMessage.RESPONSE_USER_NUMBERS_SET, lotto.toString());
        }
    }

    public void responseWinningStatisticsHeader() {
        display(OutputMessage.RESPONSE_WINNING_STATISTICS_HEADER);
    }

    public void responseWinningStatisticsBody(final EnumMap<LottoWinningRanking, Integer> rankingCountMap) {
        List<Integer> list = new ArrayList<>();
        for (LottoWinningRanking ranking : LottoWinningRanking.values()) {
            if (ranking == LottoWinningRanking.NONE) {
                continue;
            }
            Integer count = rankingCountMap.getOrDefault(ranking, 0);
            list.add(count);
        }
        display(OutputMessage.RESPONSE_WINNING_STATISTICS_BODY, list.toArray());
    }

    public void responseTotalReturn(final double profit) {
        display(OutputMessage.RESPONSE_TOTAL_RETURN, profit);
    }

    public void displayErrorMessage(final String message) {
        System.out.println(message);
    }

    private void display(final OutputMessage message, Object... args) {
        System.out.printf(message.getMessage(), args);
    }
}
