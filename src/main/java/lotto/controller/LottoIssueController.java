package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.constants.LottoSetting;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoIssueController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private int getLottoCount() {
        outputView.printInputMoneyMessage();
        int moneyInput = inputView.getMoney();
        return moneyInput / LottoSetting.LOTTO_PRICE.getNumber();
    }

    private Lotto createLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return new Lotto(randomNumberGenerator.getRandomNumbers());
    }

    public Lottos createLottos() {
        Lottos lottos = new Lottos();
        int lottoCount = getLottoCount();
        for (int count = 0; count < lottoCount; count++) {
            lottos.addLotto(createLotto());
        }
        return lottos;
    }
}