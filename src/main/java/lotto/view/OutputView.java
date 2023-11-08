package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_PRINT_LOTTOS = "개를 구매했습니다.";
    private static final String PROMPT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public void printEnterPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
    }

    public void printEnterWinningNumber() {
        System.out.println();
        System.out.println(PROMPT_WINNING_NUMBER);
    }

    public void printEnterBonusNumber() {
        System.out.println();
        System.out.println(PROMPT_BONUS_NUMBER);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + PROMPT_PRINT_LOTTOS);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Map<Rank, Integer> result, double earningRate) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + result.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
