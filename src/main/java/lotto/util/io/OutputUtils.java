package lotto.util.io;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputUtils {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public static void printNumberOfPurchaseMessage(int number) {
        System.out.println(String.format(NUMBER_OF_PURCHASE_MESSAGE, number));
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> System.out.println(lotto.toString()));
    }
}
