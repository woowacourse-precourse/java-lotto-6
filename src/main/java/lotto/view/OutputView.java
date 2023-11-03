package lotto.view;

import lotto.dto.LottoDto;

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

    public void responsePurchaseCount(int count) {
        display(OutputMessage.RESPONSE_PURCHASE_COUNT, count);
    }

    public void responseUserNumbersSet(List<LottoDto> lottos) {
        for (LottoDto lotto : lottos) {
            display(OutputMessage.RESPONSE_USER_NUMBERS_SET, lotto.toString());
        }
    }

    public void responseWinningStatisticsHeader() {
        display(OutputMessage.RESPONSE_WINNING_STATISTICS_HEADER);
    }

    public void responseWinningStatisticsBody2(LottoDto lotto) {
        display(OutputMessage.RESPONSE_WINNING_STATISTICS_BODY, lotto.getNumbers().subList(0, 5));
    }

    public void responseWinningStatisticsBody(List<Integer> result) {
        display(OutputMessage.RESPONSE_WINNING_STATISTICS_BODY, result);
    }

    public void responseTotalReturn(String result) {
        display(OutputMessage.RESPONSE_TOTAL_RETURN, result);
    }

    public void displayErrorMessage(String message) {
        System.err.println(message);
    }

    private void display(OutputMessage message, Object... args) {
        System.out.printf(message.getMessage(), args);
    }
}
