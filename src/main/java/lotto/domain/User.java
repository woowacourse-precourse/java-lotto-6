package lotto.domain;

import static lotto.constants.Boolean.FALSE;
import static lotto.constants.Boolean.TRUE;

import java.util.List;
import lotto.ui.Output;

public class User {

    public Integer lottoCount;
    public List<Lotto> lottos;

    public void purchaseLotto(Money money) {
        boolean isPurchasing = TRUE.get();

        while (isPurchasing) {
            try {
                lottoCount = money.countThousand();
                lottos = LottoGenerator.createLottos(lottoCount);
                isPurchasing = FALSE.get();
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }
    }


}
