package lotto.controller;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;
import java.util.Random;

public class LottoController {
    private final InputCoin inputCoin;
    private final InputLottoNumber inputLottoNumber;
    private final OutputCoin outputCoin;

    public LottoController() {
        this.inputCoin = new InputCoin();
        this.outputCoin = new OutputCoin();
        this.inputLottoNumber = new InputLottoNumber();
    }

    public void startLottoRoulette() {
        Coin coin = getCoin();
        purchaseLotto();
        inputLottoNumber.buyLotto();
        Lottos lottos = getLottos(coin);
        WonLotto wonLotto = getWonLotto();
        RankResult rankResult = new RankResult();
        calculateLottoResult(rankResult, wonLotto, lottos);
        Rate rate = getRate(coin, rankResult);

    }

    private Coin getCoin() {
        int coin = inputCoin.insertCoin();
        return new Coin(coin);
    }

    private Lottos getLottos(Coin coin) {
        PublishLotto publishLotto = new PublishLotto();
        return new Lottos(publishLotto.LottoNumberGenerate(coin.getCoin() / 1000));
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

    private WonLotto getWonLotto() {
        InputLottoNumber inputLottoNumber = new InputLottoNumber();
        InputBonusLottoNumber inputBonusLottoNumber = new InputBonusLottoNumber();

        List<Integer> wonLotto = inputLottoNumber.getValue();
        Integer bonusNumber = inputBonusLottoNumber.buyBonusLotto();

        return new WonLotto(wonLotto, bonusNumber);
    }

    private void calculateLottoResult(RankResult rankResult, WonLotto WonLotto, Lottos lottos) {
        rankResult.calculateRankResult(WonLotto, lottos);
    }

    private Rate getRate(Coin coin, RankResult rankResult) {
        return new Rate(coin, rankResult);
    }

}

