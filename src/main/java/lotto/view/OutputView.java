package lotto.view;

import lotto.domain.Lottos;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String REQUIRE_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---\n";
    private static final String THREE_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String FOUR_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String FIVE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String SIX_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void anounceLottos(Lottos lottos) {
        System.out.printf(PURCHASE_MESSAGE, lottos.getLottoCnt());
        List<String> lootoResult = lottos.anounceLottos();
        for (String result : lootoResult) {
            System.out.println(result);
        }
    }

    public void announceResult(Map<String, Integer> result) {
        System.out.print(RESULT_MESSAGE);
        System.out.printf(THREE_MESSAGE, result.get("three"));
        System.out.printf(FOUR_MESSAGE, result.get("four"));
        System.out.printf(FIVE_MESSAGE, result.get("five"));
        System.out.printf(BONUS_MESSAGE, result.get("bonus"));
        System.out.printf(SIX_MESSAGE, result.get("six"));
    }

    public void accounceProfit(float profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
    }

    public void printError(String message) {
        System.out.println(message);
    }

}
