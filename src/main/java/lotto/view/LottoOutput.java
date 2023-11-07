package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class LottoOutput {

    public static String INPUT_DEPOSIT = "구매금액을 입력해 주세요.";

    public static void deposit() {
        System.out.println(INPUT_DEPOSIT);
    }
    public static void ticketsCount(int lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets + "개를 구매했습니다.");
    }
    public static void lottoTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getLotto());
        }
        System.out.println();
    }
}

