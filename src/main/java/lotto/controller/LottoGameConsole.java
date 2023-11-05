package lotto.controller;

import lotto.model.LotteryBallMachine;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameConsole {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        String inputMoney = inputView.inputMoney();
        Purchase<Lotto> purchase = new Purchase<>(inputMoney);
        int purchaseMoney = purchase.getMoney();
        int purchaseCount = purchaseMoney / 1000;

        outputView.printLottoCount(purchaseCount);
        purchase.purchaseItems(generateLotto(purchaseCount));
        outputView.printLotto(purchase.toString());
    }

    private List<Lotto> generateLotto(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(LotteryBallMachine.generateNumbers());
            lottos.add(lotto);
        }

        return lottos;
    }
}
