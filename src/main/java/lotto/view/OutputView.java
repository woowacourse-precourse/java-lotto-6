package lotto.view;

import lotto.domain.Lotto;
import lotto.type.Prize;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.println(purchasedLotto.size() + "개를 구매했습니다.");
        for(Lotto lotto : purchasedLotto) {
            lotto.sort();
            System.out.print("[");
            System.out.print(String.join(", ", lotto.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .toList()));
            System.out.println("]");
        }
        System.out.println();
    }

    public static void printLottoResults(List<Prize> result) {
        System.out.println("당첨 통계\n---");
        for(Prize prize: Prize.values()) {
            if(prize.equals(Prize.NONE)) {
                continue;
            }
            int num = result.stream()
                    .filter(r -> prize.getResult().equals(r.getResult()))
                    .toList()
                    .size();
            System.out.print(prize.getResult());
            System.out.println(" - "+ num +"개");
        }
    }

    public static void printReturnRate(double returnRate) {
        DecimalFormat decFormat = new DecimalFormat("###,###.##");
        double returnPercent = Double.parseDouble(String.format("%.1f", returnRate * 100));
        System.out.println("총 수익률은 " + decFormat.format(returnPercent) + "%입니다.");
    }
}
