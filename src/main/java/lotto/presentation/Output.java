package lotto.presentation;

import java.text.DecimalFormat;
import java.util.List;
import lotto.data.Lotto;
import lotto.data.Prize;
import lotto.data.Statics;

public class Output {


    final private String OUTPUT_PURCHASED_LOTTOS = "개를 구매했습니다.";

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + OUTPUT_PURCHASED_LOTTOS);
        for (Lotto lotto : lottos) {
            lotto.print();
        }
    }

    void printSingleWinningStatic(Prize prices, Statics statics) {
        List<Integer> staticsCount = statics.getCount();
        StringBuilder stringBuilder = new StringBuilder();
        if (prices.equals(Prize.BONUS)){
            System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
            System.out.print(statics.getCountNumber(prices.ordinal()));
            System.out.println("개");
            return;
        }
        stringBuilder.append(prices.ordinal() + 3);
        stringBuilder.append("개 일치 (");
        DecimalFormat df = new DecimalFormat("###,###");
        String money = df.format(prices.getMoney());
        stringBuilder.append(money);
        stringBuilder.append("원) - ");
        stringBuilder.append(statics.getCountNumber(prices.ordinal()));
        stringBuilder.append("개");
        System.out.println(stringBuilder.toString());
    }

    public void printMultipleWinningStatics(Statics statics) {
        System.out.println("\n" + "당첨 통계");
        System.out.println("---");
        printSingleWinningStatic(Prize.FOURTH, statics);
        printSingleWinningStatic(Prize.THIRD, statics);
        printSingleWinningStatic(Prize.SECOND, statics);
        printSingleWinningStatic(Prize.BONUS, statics);
        printSingleWinningStatic(Prize.FIRST, statics);
        System.out.println("총 수익률은 " + statics.getProfit() + "%입니다.");
    }


}
