package lotto.view;

import lotto.domain.LottoCount;
import lotto.domain.Lottos;

public class PrintHandler {
    public static void printStartingPartOfLottoGame(LottoCount lottoCount, Lottos lottos) {
        Printer.printLineBreak();

        Printer.printLottoCount(lottoCount);
        printLottos(lottos);

        Printer.printLineBreak();
    }

    private static void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            Printer.printLotto(lottos.get(i));
        }
    }
}
