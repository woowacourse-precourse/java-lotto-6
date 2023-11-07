package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.Lotto;
import lotto.type.Win;

public class Print {

    private static final String BUY_MASSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String PROFIT_MESSAGE1 = "총 수익률은 ";
    private static final String PROFIT_MESSAGE2 = "%입니다.";

    public void lottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + BUY_MASSAGE);
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).printNumbers());
        }
        System.out.println();
    }

    public void result(int[] result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(Win.FIFTH.getMessage() + result[Win.FIFTH.getCollectCount()]);
        System.out.println(Win.FOURTH.getMessage() + result[Win.FOURTH.getCollectCount()]);
        System.out.println(Win.THIRD.getMessage() + result[Win.THIRD.getCollectCount()]);
        System.out.println(Win.SECOND.getMessage() + result[Win.SECOND.getCollectCount()]);
        System.out.println(Win.FIRST.getMessage() + result[Win.FIRST.getCollectCount()]);
    }

    public void profit(double profit) {
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        System.out.println(PROFIT_MESSAGE1 + formatter.format(profit) + PROFIT_MESSAGE2);
    }
}
