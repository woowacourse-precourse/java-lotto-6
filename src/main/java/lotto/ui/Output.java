package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.Prize;
import lotto.domain.LottoManager;
import lotto.domain.Lotto;

public class Output {

    public static void printError(IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
    }

    public static void printPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottos(List<Lotto> lottos) {
        List<Lotto> sortedLottos = LottoManager.sortLottos(lottos);

        for (Lotto sortedLotto : sortedLottos) {
            System.out.println(sortedLotto.getNumbers());

        }
    }

    public static void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printResult(Map<Prize, Integer> lottoResult, Double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Prize prize : lottoResult.keySet()) {
            System.out.println(prize.getDescription() + lottoResult.get(prize) + "개");

        }

        System.out.printf("총 수익률은 %,.1f%%입니다.%n", earningRate);
    }
}
