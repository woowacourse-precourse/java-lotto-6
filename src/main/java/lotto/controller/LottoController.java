package lotto.controller;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputLottoNumber;

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
        User user = buyTicket();
        Lottos lottos = pickRandomLottos(user.getLottoCount());
        WinningLotto winningLotto = pickWinningLotto();
        long prizeAmount = checkLottoResult(lottos, winningLotto);
        OutputView.printRateOfReturn(user.getBalance(), prizeAmount);
    }

    private User buyTicket() {
        while (true) {
            try {
                int purchaseAmount = InputView.inputPurchaseAmount();
                return new User(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private long checkLottoResult(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoResult, Integer> resultStorage = lottoService.getLottoResult(lottos, winningLotto);
        OutputView.printLottoResult(resultStorage);
        return lottoService.sumTotalLottoPrize(resultStorage);
    }

    private WinningLotto pickWinningLotto() {
        Lotto answerLotto = getAnswerLotto();
        while(true) {
            try {
                return new WinningLotto(answerLotto, getBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos pickRandomLottos(int lottoCount) {
        Lottos lottos = lottoService.generateLottos(lottoCount);
        OutputView.printPurchaseResult(lottoCount, lottos);
        return lottos;
    }

    private Lotto getAnswerLotto() {
        while (true) {
            try {
                return new Lotto(inputLottoNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
