package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PublishLotto;
import lotto.view.InputCoin;
import lotto.view.OutputCoin;
import lotto.view.OutputLottoKinds;

import java.util.List;

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
        makeLotto(lottoCount);
        outputCoin.printLottoKind(lottoCount);
    }

    public List<Lotto> makeLotto(int lottoCount) {
        PublishLotto publishLotto = new PublishLotto();
        return publishLotto.LottoNumberGenerate(lottoCount);
    }






}

