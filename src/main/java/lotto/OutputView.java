package lotto;

import java.util.List;

public class OutputView {

    public void print(int purchaseQuantity) {
        final String message = "개를 구매했습니다.";
        System.out.println(purchaseQuantity + message);
    }

    public void print(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
