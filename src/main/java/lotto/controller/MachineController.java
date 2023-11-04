package lotto.controller;

import lotto.model.Human;
import lotto.model.WinningLotto;
import lotto.view.PurchaseView;
import lotto.view.WinningLottoView;

import java.util.List;

public class MachineController {
    private Human human;
    private WinningLotto winningLotto;

    public void execution() {
        initAmount();
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
}
