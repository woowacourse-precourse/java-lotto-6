package lotto.View;

import lotto.Domain.Lotto;

import java.util.List;

public class LottoOutputView {
    private static final String PURCHASED_MSG_PREFIX = "원으로 ";
    private static final String PURCHASED_MSG_SUFFIX = "개를 구매했습니다.";
    public void displayPurchasedTickets(List<Lotto> tickets) {
        int totalPrice = tickets.size() * 1000;
        System.out.println(totalPrice + PURCHASED_MSG_PREFIX + tickets.size() + PURCHASED_MSG_SUFFIX);

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
