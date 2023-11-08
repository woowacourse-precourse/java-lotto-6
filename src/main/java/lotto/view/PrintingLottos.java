package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class PrintingLottos {

    public PrintingLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }
}
