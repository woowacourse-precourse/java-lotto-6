package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static final String LINE_BREAK = System.lineSeparator();

    public static void printPlayerLottos(int lottoCount, List<Lotto> lottoNumbers) {
        System.out.print(LINE_BREAK);
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottoNumbers.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
