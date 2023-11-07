package lotto.controller;

import lotto.model.*;
import lotto.view.OutputView;
import lotto.view.PurchaseView;
import lotto.view.WinningLottoView;

import java.util.*;

public class MachineController {
    public void execution() {
        Human human = initAmount();
        Lottos lottos = new Lottos(human.getCount());
        OutputView.displayPurchaseList(lottos);
        WinningLotto winningLotto = initWinningLotto();
        LottoMachine lottoMachine = new LottoMachine(lottos, winningLotto, human.getCount());
        OutputView.displayLottoCompareResult(lottoMachine.getLottoCompares());
        OutputView.displayProfit(lottoMachine.calcProfit(human.getMoney()));
    }

    public Human initAmount() {
        int money = PurchaseView.lotto();
        return new Human(money);
    }

    public WinningLotto initWinningLotto() {
        List<Integer> lottos = WinningLottoView.publishLotto();
        int bonus = WinningLottoView.publishBonus(lottos);
        return new WinningLotto(lottos, bonus);
    }
}
