package lotto.ui;

import java.util.List;
import lotto.domain.LottoManager;
import lotto.domain.Lotto;

public class Output {

    public static void printError(IllegalArgumentException ex){
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
    public static void printBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printResult(List<Integer> lottoResult, Double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.get(0) + "개");
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", earningRate);
    }
}
