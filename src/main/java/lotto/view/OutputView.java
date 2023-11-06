package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    public static void printRequestBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyCount(int count) {
        System.out.println("\n" + count / 1000 + "개를 구매했습니다.");
    }


    public static void printCreatedLottos(Lottos lottos) {
        List<List<Integer>> numbers = lottos.getLottos().stream().map(Lotto::getNumbers).toList();
        numbers.forEach(number -> System.out.println(number));
    }

    public static void printRequestWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printStartResult() {
        System.out.println("\n당첨 통계\n---");
    }


    public static void printWinningResult(int[] result) {

        System.out.println(3 + "개 일치 (5,000원) - " + result[1] + "개");
        System.out.println(4 + "개 일치 (50,000원) - " + result[2] + "개");
        System.out.println(5 + "개 일치 (1,500,000원) - " + result[3] + "개");
        System.out.println(5 + "개 일치, 보너스 볼 일치 (30,000,000원) - " + result[4] + "개");
        System.out.println(6 + "개 일치 (2,000,000,000원) - " + result[5] + "개");

    }

    public static void printProfitRate(float profitRate) {
        System.out.print("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
