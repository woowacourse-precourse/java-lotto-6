package lotto.view;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;

public class OutputView {
    private static final String OUTPUT_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_NUMBERS_MESSAGE = "[%d, %d, %d, %d, %d, %d]";

    public static void outputAllLottoNumbers(Lottos lottos) {
        List<Lotto> outputLottos = lottos.getAllLotto();
        System.out.println(String.format(OUTPUT_LOTTO_COUNT_MESSAGE, outputLottos.size()));

        outputLottos.forEach(
                lotto -> System.out.println(String.format(OUTPUT_LOTTO_NUMBERS_MESSAGE, lotto.getNumbers().toArray())));

    }
}
