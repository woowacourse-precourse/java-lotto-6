package lotto.controller;

import lotto.view.InputCoin;
import lotto.view.OutputCoin;
import lotto.view.OutputLottoKinds;

public class LottoController {
    private final InputCoin inputCoin;
    private final OutputLottoKinds outputLottoKinds;
    private final OutputCoin outputCoin;

    public LottoController() {
        this.inputCoin = new InputCoin();
        this.outputLottoKinds = new OutputLottoKinds();
        this.outputCoin = new OutputCoin();
    }

    public void startLottoRoulette() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        int money = inputCoin.insertCoin();
        int lottoCount = money / 1000;
        outputCoin.printLottoKind(lottoCount);
    }
}

