package lotto.view;

import lotto.domain.*;
import lotto.utility.FormatConverter;

public class PrintHandler {
    public static void printStartingPartOfLottoGame(LottoCount lottoCount, Lottos lottos) {
        Printer.printLottoCount(lottoCount);
        printLottos(lottos);

        Printer.printLineBreak();
    }

    public static void printEndingPartOfLottoGame(Winnings winnings, ReturnRate returnRate) {
        Printer.printResultHead();
        Printer.printDividingLine();

        printResultOfGame(winnings);
        Printer.printReturnRate(returnRate);
    }

    private static void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            Printer.printLotto(lottos.get(i));
        }
    }

    private static void printResultOfGame(Winnings winnings) {
        for (int i = 3; i <= 5; i++) {
            Winning winning = FormatConverter.toWinningFromIntValue(i);
            WinningCount winningCount = winnings.getWinningCount();

            Printer.printLowWinningResult(i, winning, winningCount);
        }

        for (int i = 7; i >= 6; i--) {
            Winning winning = FormatConverter.toWinningFromIntValue(i);
            WinningCount winningCount = winnings.getWinningCount();
            Printer.printHighWinningResult(i, winning, winningCount);
        }

    }
}
