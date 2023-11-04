package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;

public class LottoPublisher {
    private List<Lotto> userLottos;

    public void createLotto() {
        List<Lotto> lottos = new ArrayList<>();
        while (countLottos() != 0) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        this.userLottos = userLottos;
    }

    private int countLottos() {
        return InputView.requestPurchasePrice() / 1000;
    }
}
