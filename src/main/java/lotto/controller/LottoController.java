package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;

public class LottoController {
    private static ArrayList<Lotto> myLottos = new ArrayList<>();
    public void play() {

    }

    public void start() {
        Money money = new Money();
        buyLottos(money.trial());
    }

    public void buyLottos(int trial) {
        OutputView.printNoticeTrialMessage(trial);
        do {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            myLottos.add(lotto);
        } while (myLottos.size() < trial);
    }
}
