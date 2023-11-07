package lotto;

import java.util.List;
import lotto.dto.LottoNumberDTO;

public class Printer {
    private static Printer printer;

    private Printer() {}

    public static Printer getPrinter() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public void countOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }

    public void allLotto(List<LottoNumberDTO> lottos) {
        for (LottoNumberDTO lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
        System.out.println();
    }
}
