package lotto.view;

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

    public void responsePurchaseCount(String count) {
        display(OutputMessage.RESPONSE_PURCHASE_COUNT, count);
    }

    public void responseWinningNumbers(String result) {
        display(OutputMessage.RESPONSE_WINNING_NUMBERS, result);
    }

    public void responseWinningStatisticsHeader() {
        display(OutputMessage.RESPONSE_WINNING_STATISTICS_HEADER);
    }

    public void responseWinningStatisticsBody(String result) {
        display(OutputMessage.RESPONSE_WINNING_STATISTICS_BODY, result);
    }

    public void responseTotalReturn(String result) {
        display(OutputMessage.RESPONSE_TOTAL_RETURN, result);
    }

    private void display(OutputMessage message, Object... args) {
        System.out.printf(message.getMessage(), args);
    }
}
