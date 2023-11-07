package lotto.View;

import lotto.Lotto;

import java.util.List;

public class output {
    public static void printLotto(List<Lotto> lottoTickets) {
        int purchaseAmount = lottoTickets.size();
        System.out.println(purchaseAmount + "개를 구매했습니다.");

        for (Lotto lottoTicket : lottoTickets) {
            List<Integer> numbers = lottoTicket.getNumbers();
            System.out.println(numbers);
        }
    }
}
