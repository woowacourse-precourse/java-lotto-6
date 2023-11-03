package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.constants.LottoSetting;
import lotto.util.RandomNumberGenerator;
import lotto.view.OutputView;

public class LottoIssueController {
    public int getLottoCount(int inputMoney) {
        return inputMoney / LottoSetting.LOTTO_PRICE.getNumber();
    }

    private Lotto createLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return new Lotto(randomNumberGenerator.getRandomNumbers());
    }

    public Lottos createLottos(int inputMoney) {
        Lottos lottos = new Lottos();
        int lottoCount = getLottoCount(inputMoney);

        for (int count = 0; count < lottoCount; count++) {
            lottos.addLotto(createLotto());
        }
        return lottos;
    }
}