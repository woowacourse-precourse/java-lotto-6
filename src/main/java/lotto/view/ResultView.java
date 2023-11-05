package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class ResultView {
    public static final String TICKET_COUNT = "개를 구매했습니다.";
    public static void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }
}
