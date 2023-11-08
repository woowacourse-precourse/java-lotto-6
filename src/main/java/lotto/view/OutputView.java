package lotto.view;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.Winning;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printcreatedResult(List<Lotto> lottos) {
        printPurchaseCount();
        printLottos(lottos);
    }

    public void printPurchaseCount() {
        System.out.println(OuputMessage.purchaseCount);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .forEach((lotto -> System.out.println(lotto)));
        System.out.println();
    }

    public void printWinningResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Entry<Winning, Integer> entry : result.getResult().entrySet()) {

            Winning winning = entry.getKey();
            Integer value = entry.getValue();

            String matchCount = String.format("%d개 일치", winning.getMatchingCount());
            String bonusball = "";
            if (winning.isHasBonusNumber()) {
                bonusball = ", 보너스 볼 일치";
            }
            String price = String.format(" (%,d원)", winning.getAmount());
            String count = String.format(" - %d개", value);

            System.out.println(matchCount + bonusball + price + count);
        }
        System.out.println();
    }

    public void printRateOfReturn(double rateOfReturn) {
        String rate = String.format("%.1f", rateOfReturn);
        System.out.print("총 수익률은 " + rate + "%입니다.");
    }
}
