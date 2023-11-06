package lotto.controller;

import lotto.domain.*;
import lotto.view.*;

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

    private WonLotto getWinningLotto(String checkedInput) {
        InputLottoNumber inputLottoNumber = new InputLottoNumber();
        InputBonusLottoNumber inputBonusLottoNumber = new InputBonusLottoNumber();

        List<Integer> wonLotto = inputLottoNumber.numberConvert(checkedInput);
        Integer bonusNumber = inputBonusLottoNumber.buyBonusLotto();

        return new WonLotto(wonLotto, bonusNumber);
    }

    private void calcLottoResult(RankResult rankResult, WonLotto WonLotto, List<Lotto> lottos) {
        rankResult.calculateRankResult(WonLotto, lottos);
    }

    private Rate getRate(Coin coin, RankResult rankResult) {
        return new Rate(coin, rankResult);
    }



}

