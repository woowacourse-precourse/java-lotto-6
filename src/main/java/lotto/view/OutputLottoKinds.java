package lotto.view;

import lotto.domain.Lotto;
import java.util.List;

public class OutputLottoKinds {

    public void printLottoNumbers(int count, List<Lotto> lottos) {
        for (int i = 0; i < count; i++) {
            Lotto buyersLotto = lottos.get(i);
            printLotto(buyersLotto);
        }
    }

    public void printLotto(Lotto lotto) {
        System.out.println(lotto.)
    }
}
