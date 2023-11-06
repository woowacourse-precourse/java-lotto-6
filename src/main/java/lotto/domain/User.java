package lotto.domain;

import static lotto.constants.Boolean.FALSE;
import static lotto.constants.Boolean.TRUE;

import java.util.List;


public class User {

    public Integer lottoCount;
    public List<Lotto> lottos;


    boolean isPurchasing = TRUE.get();

    //        while (isPurchasing) {
//        try {
//        } catch (IllegalArgumentException ex) {
//            Output.printError(ex);
//        }
//        }
//    isPurchasing = FALSE.get();
    public void purchaseLotto(Money money) {
        lottoCount = money.countThousand();
        lottos = LottoGenerator.createLottos(lottoCount);
    }
}

