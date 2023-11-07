package lotto.view;

import lotto.element.Lotto;
import lotto.element.WinningDetails;
import java.util.*;

public class Output {
    void printLottoes(List<Lotto> lottoes) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoes.size());
        for (Lotto lotto : lottoes) {
            System.out.println(lotto);
        }
    }

    void printWinnings(int[] winCount) {
        for (WinningDetails wd : WinningDetails.values()) {
            System.out.print(wd);
            System.out.printf("- %d개\n", winCount[wd.ordinal()]);
        }
    }

    void printRevenue(double revenue) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", revenue);
    }

    void printError(IllegalArgumentException e) {
        System.out.print("[ERROR] ");
        System.out.println(e);
    }
}
