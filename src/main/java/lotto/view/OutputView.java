package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoEnum;
import lotto.domain.LottoResult;

import java.util.List;

    // 발행된 로또 번호 출력 로직 작성 필요
    public class OutputView {
        public static void printTickets(List<Lotto> tickets) {
            System.out.println(tickets.size() + "개를 구매했습니다.");
            for (Lotto ticket : tickets) {
                System.out.println(ticket.getNumbers());
            }
        }


    }

