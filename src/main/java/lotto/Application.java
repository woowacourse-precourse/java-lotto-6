package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.Purchase;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Purchase p = new Purchase();
        int trials = p.purchasing();

        LottoGenerator lottos = new LottoGenerator(trials);
    }
}
