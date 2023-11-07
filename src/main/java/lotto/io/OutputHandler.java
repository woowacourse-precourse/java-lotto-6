package lotto.io;

import java.util.List;
import lotto.domain.Lotto;

public class OutputHandler {
    public static void printErrorMessage(String message) {
        System.out.println("[Error] " + message);
    }

    public static void printLottoAmount(int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.convertNumbersToString());
        }
        System.out.println("");
    }

    public static void printLottoResult(String result) {
        System.out.println("\n" + "당첨 통계\n" + "---\n" + result);
    }

    public static void printLottoProfit(String result) {
        System.out.println("총 수익률은 " + result + "입니다.");
    }
}
