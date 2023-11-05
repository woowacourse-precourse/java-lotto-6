package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {
    private final static String AUTO_BUY_MESSAGE = "%d개를 구매했습니다.";
    private final static String LOTTO_PREFIX = "[";
    private final static String LOTTO_SUFFIX = "]";


    public static void printException(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printAutoLottos(final List<Lotto> autoLottos, int lottoCount) {
        System.out.printf(String.format(AUTO_BUY_MESSAGE), lottoCount);
        printEmpty();

        StringBuilder result;
        for (Lotto lotto : autoLottos) {
            result = new StringBuilder();
            result.append(LOTTO_PREFIX);
            lotto.getLotto().stream().map(String::valueOf).collect(Collectors.joining(","));
            result.append(LOTTO_SUFFIX);
            System.out.print(result);
            printEmpty();
        }
    }

    private static void printEmpty() {
        System.out.println();
    }

}
