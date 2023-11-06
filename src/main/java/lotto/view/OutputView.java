package lotto.view;

import static lotto.domain.lotto.LottoConstants.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import lotto.domain.Rankings;

public class OutputView {
    private static final String PURCHASE_RESULT = "%d개를 구매했습니다.";

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.print(lottoNumbers);
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

    public void printNewLine() {
        System.out.println();
    }
}
