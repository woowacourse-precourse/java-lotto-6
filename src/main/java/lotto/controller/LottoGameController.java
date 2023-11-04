package lotto.controller;

import lotto.domain.model.LottoPurchaseCost;
import lotto.domain.model.LottoDispenser;
import lotto.domain.model.Lottos;
import lotto.domain.LottoRandomGenerator;
import lotto.domain.Repeater;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    InputView inputView;
    OutputView outputView;
    Repeater repeater;

    public LottoGameController(InputView inputView, OutputView outputView, Repeater repeater) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.repeater = repeater;
    }

    private LottoPurchaseCost readPurchaseCost() {
        outputView.printReadCostAmountMessage();

        return repeater.repeatBeforeSuccess(() -> new LottoPurchaseCost(inputView.readCostAmount()));
    }

    private void buyLottos(int amount) {
        LottoDispenser lottoDispenser = new LottoDispenser(new LottoRandomGenerator());
        Lottos lottos = lottoDispenser.dispense(amount);
    }

    private void initGame(LottoPurchaseCost lottoPurchaseCost) {
        int lottoAmount = lottoPurchaseCost.getLottoAmount();
        buyLottos(lottoAmount);
    }


    public void play() {
        LottoPurchaseCost lottoPurchaseCost = readPurchaseCost();
        initGame(lottoPurchaseCost);
    }
}
