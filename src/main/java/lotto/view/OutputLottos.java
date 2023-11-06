package lotto.view;

import lotto.domain.Lottos;

public class OutputLottos {
    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
