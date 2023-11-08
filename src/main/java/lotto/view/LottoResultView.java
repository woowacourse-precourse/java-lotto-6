package lotto.view;

import static lotto.view.ui.Output.printlnFormatWithNewLine;
import static lotto.view.ui.Output.printlnResult;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoResultView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String SEPARATOR = ", ";
    private static final String PREFIX = "[";
    private static final String POSTFIX = "]";

    public static void print(Lottos lottos) {
        printLottosCount(lottos.getSize());
        printLottosInfo(lottos.getLottos());
    }

    private static void printLottosCount(int count) {
        printlnFormatWithNewLine(LOTTO_COUNT_MESSAGE, count);
    }

    private static void printLottosInfo(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoInfo(lotto);
        }
    }

    private static void printLottoInfo(Lotto lotto) {
        String result = String.join(SEPARATOR, convertNumbers(lotto.getNumbers()));
        printlnResult(PREFIX + result + POSTFIX);
    }

    private static String[] convertNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }
}
