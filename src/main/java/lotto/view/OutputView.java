package lotto.view;

import lotto.domain.Lotto;
import lotto.type.LottoPrize;

import java.util.List;

public class OutputView {
    public void displayLotto(List<Lotto> userLottoList) {
        System.out.println(userLottoList.size() + "개를 구매했습니다.");
        for (Lotto userLotto : userLottoList) {
            System.out.println(userLotto.getNumbers());
        }
        System.out.println();
    }

    public void displayResults(List<LottoPrize> result) {
        System.out.println("당첨 통계\n---");
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.equals(LottoPrize.NONE)) {
                continue;
            }
            int num = result.stream()
                    .filter(r -> prize.getResult().equals(r.getResult()))
                    .toList()
                    .size();
            System.out.print(prize.getResult());
            System.out.println(" - " + num + "개");
        }
    }

    public void displayReturnRatio(double returnRatio) {
        System.out.printf("총 수익률은 %.1f%%입니다.", returnRatio);
    }
}