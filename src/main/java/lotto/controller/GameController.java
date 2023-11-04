package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Statistics;
import lotto.utility.RandomNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    
    int amount; //로또 구입 총액
    int count; //로또 발행 개수

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomNumber randomNumber = new RandomNumber();
    LottoStore lottoStore = LottoStore.getInstance();

    public void proceed() {
        init();
        LottoPublish();
        winningLotto();
    }

    private void winningLotto() {
        lottoStore.setWinningLotto(String.valueOf(inputView.printWinningNumber()));
        lottoStore.setBonusNumber(inputView.printBonusNumber());
    }

    private void LottoPublish() {
        for (int i = 0; i < count; i++) {
            Lotto.createLotto(randomNumber.makeLottoNumber());
        }
        outputView.printLottoHistory(lottoStore.getLottoHistory());
    }


    private void init() {
        amount = inputView.printPurchaseAmount();
        count = amount / 1000;
        outputView.printPurchase(count);
    }
}
