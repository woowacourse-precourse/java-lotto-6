package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class OutputLottos {
    public OutputLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }
}
