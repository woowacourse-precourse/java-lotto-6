package lotto.view;

import static lotto.domain.lotto.LottoConstants.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import lotto.domain.Rankings;
import lotto.domain.lotto.Lotto;

public class OutputView {

    private static final String PURCHASE_RESULT = "\n%d개를 구매했습니다.";
    private static final String YIELD_RESULT = "총 수익률은 %s입니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";

    public void printIssuedLotto(List<Lotto> issuedLotto) {
        for (Lotto lotto : issuedLotto) {
            System.out.println(lotto);
        }
        printNewLine();
    }

    public void printPurchaseResultMessage(int userPurchaseAmount) {
        System.out.printf(PURCHASE_RESULT, userPurchaseAmount / LOTTO_PRICE.getValue());
        printNewLine();
    }

    public void printWinningResult(Map<Rankings, Integer> finalResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        finalResult.forEach((key, value) -> {
            System.out.println(key.getMessage(value));
        });
    }

    public void printYield(String yield) {
        System.out.printf(YIELD_RESULT, yield);
    }

    private void printNewLine() {
        System.out.println();
    }
}
