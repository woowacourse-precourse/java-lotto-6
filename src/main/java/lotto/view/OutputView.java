package lotto.view;

import static lotto.ViewMessage.BONUS_PROMPT_MESSAGE;
import static lotto.ViewMessage.PAYMENT_PROMPT_MESSAGE;
import static lotto.ViewMessage.WINNING_NUMBERS_PROMPT_MESSAGE;
import static lotto.ViewMessage.WINNING_RESULT_MESSAGE;

public class OutputView {
    public void paymentPrompt() {
        System.out.println(PAYMENT_PROMPT_MESSAGE);
    }

    public void bonusPrompt() {
        System.out.println(BONUS_PROMPT_MESSAGE);
    }

    public void winningNumberPrompt() {
        System.out.println(WINNING_NUMBERS_PROMPT_MESSAGE);
    }

    public void printLottoTickets(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printWinningResult(String winningResult) {
        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(winningResult);
    }

    public void printRateOfRevenue(String rateOfRevenue) {
        System.out.printf(rateOfRevenue);
    }
}
