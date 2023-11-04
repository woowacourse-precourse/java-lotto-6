package lotto.controller;

import lotto.model.Human;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.utils.Random;
import lotto.view.OutputView;
import lotto.view.PurchaseView;
import lotto.view.WinningLottoView;

import java.util.ArrayList;
import java.util.List;

public class MachineController {
    private Human human;
    private WinningLotto winningLotto;
    private Lottos lottos;

    public void execution() {
        initAmount();
        initLottos();
        OutputView.displayPurchaseList(lottos);
        initWinningLotto();
    }

    public void initAmount() {
        int money = PurchaseView.lotto();
        human = new Human(money);
    }

    public void initWinningLotto() {
        List<Integer> lottos = WinningLottoView.publishLotto();
        int bonus = WinningLottoView.publishBonus(lottos);
        winningLotto = new WinningLotto(lottos, bonus);
    }

    public void initLottos() {
        int count = human.getCount();
        List<Lotto> tempLottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            tempLottos.add(new Lotto(Random.generate()));
        }
        lottos = new Lottos(tempLottos);
    }
}
