package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.message.ConsoleMessage;

public class OutputView {
    private static final String LOTTO_PRINT_FRONT  = "[";
    private static final String LOTTO_SEPERATOR = ", ";
    private static final String LOTTO_PRINT_END = "]";
    public static void printErrorMessage(String message) {
        System.out.println(ConsoleMessage.ERROR_STRING.getMessage() + message);
    }
    public static void printPurchaseCount(int count) {
        System.out.println(count + ConsoleMessage.CREATE_LOTTOS_COUNT.getMessage());
    }

    public static void printLottos(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(printPerlotto(lotto));
        }
        System.out.println();
    }

    private static String printPerlotto(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LOTTO_PRINT_FRONT);

        for(Integer number : lotto.getNumbers()) {
            stringBuilder.append(number);
            stringBuilder.append(LOTTO_SEPERATOR);
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(LOTTO_PRINT_END);
        return stringBuilder.toString();
    }
}
