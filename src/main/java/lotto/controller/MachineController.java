package lotto.controller;

import lotto.model.*;
import lotto.utils.LottoCompare;
import lotto.utils.Random;
import lotto.view.OutputView;
import lotto.view.PurchaseView;
import lotto.view.WinningLottoView;

import java.util.*;

public class MachineController {
    private Human human;
    private WinningLotto winningLotto;
    private Lottos lottos;

    public void execution() {
        initAmount();
        lottos = new Lottos(human.getCount());
        OutputView.displayPurchaseList(lottos);
        initWinningLotto();
        LottoMachine lottoMachine = new LottoMachine(lottos, winningLotto, human.getCount());
        OutputView.displayLottoCompareResult(lottoMachine.getLottoCompares());
        OutputView.displayProfit(lottoMachine.calcProfit(human.getMoney()));
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
