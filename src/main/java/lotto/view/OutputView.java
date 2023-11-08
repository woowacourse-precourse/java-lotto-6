package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.List;
import lotto.script.Price;

public class OutputView {
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void showResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + Price.PRIZE_THREE_MATCH.getMessage() + ") - " + result.getThreeMatchCount() + "개");
        System.out.println("4개 일치 (" + Price.PRIZE_FOUR_MATCH.getMessage() + ") - " + result.getFourMatchCount() + "개");
        System.out.println("5개 일치 (" + Price.PRIZE_FIVE_MATCH.getMessage() + ") - " + result.getFiveMatchCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + Price.PRIZE_FIVE_MATCH_WITH_BONUS.getMessage()+ ") - " + result.getFiveMatchWithBonusCount() + "개");
        System.out.println("6개 일치 (" + Price.PRIZE_SIX_MATCH.getMessage() + ") - " + result.getSixMatchCount() + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.getProfitRate());
    }
}
