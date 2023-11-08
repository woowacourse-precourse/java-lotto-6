package lotto.view;

import lotto.dto.PurchaseResult;
import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    private static final String READ_CASH_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public static void printReadCashMessage() {
        System.out.println(READ_CASH_PROMPT_MESSAGE);
    }

    public static void printPurchaseResult(PurchaseResult purchaseResult) {
        printLottoNumber(purchaseResult.getQuantity());
        printLottos(purchaseResult.getLottos());
    }

    private static void printLottoNumber(int number) {
        System.out.printf("%d개를 구매했습니다.\n", number);
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printReadWinningNumberMessage() {
        System.out.println(READ_WINNING_NUMBER);
    }

}
