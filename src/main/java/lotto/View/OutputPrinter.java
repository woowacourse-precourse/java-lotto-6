package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.TotalLotto;

public class OutputPrinter {

    public void printTotalLotto(TotalLotto totalLotto) {
        System.out.println();
        System.out.println(totalLotto.getLottoAmount() + "개를 구매했습니다.");
        for (Lotto lotto : totalLotto.getTotalLotto()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
