package lotto.view;

import static lotto.type.Win.FIFTH;
import static lotto.type.Win.FIRST;
import static lotto.type.Win.FOURTH;
import static lotto.type.Win.SECOND;
import static lotto.type.Win.THIRD;

import java.text.DecimalFormat;
import java.util.List;
import lotto.Lotto;

public class Print {

    private static final String BUY_MASSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE1 = "당첨 통계\n---";
    private static final String RESULT_MESSAGE2 = "개";
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
        System.out.println(RESULT_MESSAGE1);
        System.out.println(FIFTH.getMessage() + result[FIFTH.getCollectCount()] + RESULT_MESSAGE2);
        System.out.println(FOURTH.getMessage() + result[FOURTH.getCollectCount()] + RESULT_MESSAGE2);
        System.out.println(THIRD.getMessage() + result[THIRD.getCollectCount()] + RESULT_MESSAGE2);
        System.out.println(SECOND.getMessage() + result[SECOND.getCollectCount()] + RESULT_MESSAGE2);
        System.out.println(FIRST.getMessage() + result[FIRST.getCollectCount()] + RESULT_MESSAGE2);
    }

    public void profit(double profit) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        System.out.println(PROFIT_MESSAGE1 + formatter.format(profit) + PROFIT_MESSAGE2);
    }
}
