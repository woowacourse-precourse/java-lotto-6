package lotto.view;

import lotto.dto.LottoNumbers;
import lotto.dto.PurchasedLotto;
import lotto.dto.WinningResult;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        int purchasesNumber = purchasedLotto.purchasesNumber();
        printLineSeparator();
        System.out.printf("%d개를 구매했습니다.", purchasesNumber);
        printLineSeparator();

        List<LottoNumbers> lottos = purchasedLotto.lottos();
        lottos.stream()
                .map(DisplayFormatter::formatLottoNumbers)
                .forEach(System.out::println);
        printLineSeparator();
    }

    public static void printWinningResult(WinningResult winningResult) {
        printLineSeparator();
        System.out.println("당첨 통계");
        System.out.println("---");

        winningResult.winningStatuses().stream()
                .map(DisplayFormatter::formatWinningStatus)
                .forEach(System.out::println);

        double returnRate = winningResult.returnRate();
        System.out.printf("총 수익률은 %.1f%%입니다.", returnRate);
    }

    private static void printLineSeparator() {
        System.out.println();
    }
}
