package lotto.view;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.List;

public class OutputView {

    public void showPurchaseMessage(int buyingCount) {
        System.out.println("");
        System.out.println(buyingCount + "개를 구매했습니다.");
    }

    public void showPurchasedLottoNumbers(List<Lotto> numbers) {
        for (Lotto lotto : numbers) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println("");
    }

    public void showResult() {
        List<Ranking> rankings = Arrays.stream(Ranking.values()).toList();
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Ranking ranking : rankings) {
            System.out.println(ranking.getMessage() + " - " + ranking.getCount() + "개");
        }
    }
    public void showPayOff(double payOff){
        System.out.println("총 수익률은 " + payOff + "%입니다.");
    }
}
