package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPurchase;
import lotto.domain.lotto.Lottos;
import lotto.domain.roulette.RouletteResult;
import lotto.domain.roulette.WinningLotto;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGameController {
    private LottoGameService lottoGameService;
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController() {
        lottoGameService = new LottoGameService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        LottoPurchase lottoPurchase = getMoney();
        showLottoCount(lottoPurchase);

        Lottos lottos = lottoGameService.buyLottos(lottoPurchase);
        showLottosNumber(lottos);

        Lotto winningNumber = getWinningNumber();
        WinningLotto winningLotto = getBonusNumber(winningNumber);
        Map<RouletteResult, Integer> result = lottoGameService.match(winningLotto, lottos);
        showResult(result);
        showRate(lottoPurchase);
    }

    public LottoPurchase getMoney() {
        try {
            int money = inputView.inputMoney();
            return LottoPurchase.of(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    public Lotto getWinningNumber() {
        try {
            List<Integer> numbers = inputView.inputWinningNumber();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    public WinningLotto getBonusNumber(Lotto lotto) {
        try {
            int bonusNumber = inputView.inputBonusNumber();
            return WinningLotto.of(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(lotto);
        }
    }

    public void showLottoCount(LottoPurchase lottoPurchase) {
        int count = lottoPurchase.getCount();
        outputView.outputLottoCount(count);
    }

    public void showLottosNumber(Lottos lottos) {
        List<Lotto> boughtLottos = lottos.getLottos();
        outputView.outputLottosNumber(boughtLottos);
    }

    public void showResult(Map<RouletteResult, Integer> result) {
        outputView.showResult(result);
    }

    public void showRate(LottoPurchase lottoPurchase) {
        double rate = lottoGameService.getRate(lottoPurchase);
        outputView.showRate(rate);
    }

}
