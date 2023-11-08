package lotto.view;

import lotto.domain.Lottos;

public class outputLottosListView {
    public static void printLottosList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
