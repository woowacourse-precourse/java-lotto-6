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

    public int getMoneyInput() {
        outputView.printInputMoneyMessage();
        return inputView.getMoney();
    }

    public int getLottoCount(int inputMoney) {
        return inputMoney / LottoSetting.LOTTO_PRICE.getNumber();
    }

    private Lotto createLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return new Lotto(randomNumberGenerator.getRandomNumbers());
    }

    public Lottos createLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for (int count = 0; count < lottoCount; count++) {
            lottos.addLotto(createLotto());
        }
        return lottos;
    }

    public void getPurchaseDetails(Lottos lottos, int lottoCount) {
        outputView.printPurchaseDetailsMessage(lottoCount);
        outputView.printPurchasedLottos(lottos.getPurchasedLottos());
    }
}