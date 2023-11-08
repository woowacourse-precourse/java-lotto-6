package lotto.view;

import lotto.domain.Lottos;

public class OutputLottolist {
    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
