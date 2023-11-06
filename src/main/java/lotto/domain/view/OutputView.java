package lotto.domain.view;

import java.util.List;
import lotto.domain.model.Lotto;

public class OutputView {
    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
