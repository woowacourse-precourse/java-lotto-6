package lotto.controller;

import lotto.domain.LottoPurchaseMachine;
import lotto.domain.Lottos;
import lotto.view.LottoPurchaseOutputView;

public class LottoPurchaseController {
    private LottoPurchaseMachine lottoPurchaseMachine;
    private MoneyInputController moneyInputController;
    private LottoPurchaseOutputView lottoPurchaseOutputView;

    public LottoPurchaseController() {
        lottoPurchaseMachine = new LottoPurchaseMachine();
        moneyInputController = new MoneyInputController();
        lottoPurchaseOutputView = new LottoPurchaseOutputView();
    }

    public Lottos purchaseLottos() {
        int money = moneyInputController.inputMoney();
        int lottoCount = money / 1000;
        Lottos lottos = lottoPurchaseMachine.purchaseLottos(lottoCount);
        lottoPurchaseOutputView.outputLotto(lottos, lottoCount);
        return lottos;
    }
}
