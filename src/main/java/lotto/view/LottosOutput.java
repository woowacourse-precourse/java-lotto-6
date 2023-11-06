package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.LottoGenerate;

public class LottosOutput {

    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void lottosOutput(int tickets) {
        System.out.println(tickets + TICKET_COUNT_MESSAGE);
        Lottos lottos = new Lottos(LottoGenerate.lottos(tickets));
        printLottos(lottos.toString());
    }

    public static void printLottos(String lottos) {
        System.out.println(lottos);
        System.out.println("");
    }
}
