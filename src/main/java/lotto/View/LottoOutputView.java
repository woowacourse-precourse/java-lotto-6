package lotto.View;

import lotto.Domain.Lotto;

import java.util.List;

import lotto.Domain.ErrorMessage;

public class LottoOutputView {

    public void displayPurchasedTickets(List<Lotto> tickets) {
        int totalPrice = tickets.size() * 1000;
        System.out.println(totalPrice + ErrorMessage.PURCHASED_MSG_PREFIX + tickets.size() + ErrorMessage.PURCHASED_MSG_SUFFIX);

        for (Lotto ticket : tickets) {
            List<Integer> sortedNumbers = ticket.getSortedNumbers();
            System.out.println(sortedNumbers);
        }
    }

    public void displayResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }
}
