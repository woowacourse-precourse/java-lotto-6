package lotto.view;

import lotto.domain.Lottos;

public class PrintHandler {
    public static void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            Printer.printLotto(lottos.get(i));
        }
    }
}
