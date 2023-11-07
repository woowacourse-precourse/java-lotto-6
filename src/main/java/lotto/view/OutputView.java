package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void askPurchaseAmount() {
        System.out.println(Messages.ASK_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void showPurchasedLottoTicketsNumber(int ticketNumber) {
        System.out.println();
        System.out.println(Messages.PURCHASE_SUCCESS.getCountMessage(ticketNumber));
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
        System.out.println(Messages.ASK_WINNING_NUMBERS_MESSAGE.getMessage());
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println(Messages.ASK_BONUS_NUMBER_MESSAGE.getMessage());
    }
}
