package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningRanking;
import lotto.dto.LottoWinningRakingCountMapDto;
import lotto.dto.LottosDto;

import java.util.ArrayList;
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

    public void responseUserNumbersSet(final LottosDto lottosDto) {
        for (Lotto lotto : lottosDto.getLottoGroup()) {
            display(OutputMessage.RESPONSE_USER_NUMBERS_SET, lotto.toString());
        }
    }

    public void responseWinningStatisticsHeader() {
        display(OutputMessage.RESPONSE_WINNING_STATISTICS_HEADER);
    }

    public void responseWinningStatisticsBody(final LottoWinningRakingCountMapDto rankingCountMapDto) {
        List<Integer> rankingCountList = new ArrayList<>();
        for (LottoWinningRanking ranking : LottoWinningRanking.values()) {
            if (ranking != LottoWinningRanking.NONE) {
                Integer count = rankingCountMapDto.getWinningRankingCountMap().getOrDefault(ranking, 0);
                rankingCountList.add(count);
            }
        }

        display(OutputMessage.RESPONSE_WINNING_STATISTICS_BODY, rankingCountList.toArray());
    }

    public void responseProfit(final double profit) {
        display(OutputMessage.RESPONSE_TOTAL_RETURN, profit);
    }

    public void displayErrorMessage(final String message) {
        System.out.println(message);
    }

    private void display(final OutputMessage message, Object... args) {
        System.out.printf(message.getMessage(), args);
    }
}
