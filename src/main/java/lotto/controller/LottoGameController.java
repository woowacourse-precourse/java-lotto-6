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
        LottoPurchase lottoPurchase = buyLottos();
        showLottoCount(lottoPurchase);
        // 구매한 금액으로 로또 발행
        Lottos lottos = lottoGameService.buyLottos(lottoPurchase);
        // 발급된 로또 정보 출력
        showLottosNumber(lottos);
        // 당첨번호, 보너스 번호 입력받기
        Lotto winningNumber = getWinningNumber();
        WinningLotto winningLotto = getBonusNumber(winningNumber);
        // 결과 계산
        Map<RouletteResult, Integer> result = lottoGameService.match(winningLotto, lottos);
        // 결과 출력하기
        showResult(result);
        showRate(lottoPurchase);
    }

    public LottoPurchase buyLottos() {
        try {
            int money = inputView.inputMoney();
            return LottoPurchase.of(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLottos();
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
