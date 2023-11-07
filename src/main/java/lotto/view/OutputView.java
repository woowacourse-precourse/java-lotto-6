package lotto.view;

import static lotto.domain.lotto.LottoConstants.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import lotto.domain.Rankings;
import lotto.domain.lotto.Lotto;

public class OutputView {

    private static final String PURCHASE_RESULT = "%d개를 구매했습니다.";
    private static final String MARGIN_RESULT = "총 수익률은 %s입니다.";

    public void printIssuedLotto(List<Lotto> issuedLotto) {
        for (Lotto lotto : issuedLotto) {
            System.out.println(lotto.getNumbers());
        }
        printNewLine();
    }

    public void printPurchaseResultMessage(int userPurchaseAmount) {
        printNewLine();
        System.out.printf(PURCHASE_RESULT, userPurchaseAmount / LOTTO_PRICE.getValue());
        printNewLine();
    }

    public void printWinningResult(Map<Rankings,Integer> finalResult) {
        finalResult.forEach((key, value) -> {
            System.out.println(key.getMessage(value));
        });
    }

    public void printMargin(String margin) {
        System.out.printf(MARGIN_RESULT, margin);
    }

    public void printNewLine() {
        System.out.println();
    }
}
