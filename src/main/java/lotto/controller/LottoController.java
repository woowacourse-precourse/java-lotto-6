package lotto.controller;

import static lotto.view.InputView.*;
import static lotto.view.InputView.inputPurchaseAmount;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoService lottoService = new LottoService();

    public void play() {
        User user = new User(inputPurchaseAmount());
        Lottos lottos = pickRandomLottos(user.getLottoCount());
        WinningLotto winningLotto = pickWinningLotto();
        long prizeAmount = checkLottoResult(lottos, winningLotto);
        OutputView.printRateOfReturn(user.getBalance(), prizeAmount);
    }

    private long checkLottoResult(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoResult, Integer> lottoResult = lottoService.getLottoResult(lottos, winningLotto);
        OutputView.printLottoResult(lottoResult);
        return lottoService.sumTotalLottoPrize(lottoResult);
    }

    private WinningLotto pickWinningLotto() {
        Lotto lottoAnswer = new Lotto(inputLottoNumber());
        int bonusNumber = inputBonusNumber();
        return new WinningLotto(lottoAnswer, bonusNumber);
    }

    private Lottos pickRandomLottos(int lottoCount) {
        Lottos lottos = lottoService.generateLottos(lottoCount);
        OutputView.printPurchaseResult(lottoCount, lottos);
        return lottos;
    }

}
