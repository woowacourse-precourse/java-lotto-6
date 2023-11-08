package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPurchase;
import lotto.domain.lotto.Lottos;
import lotto.domain.roulette.Roulette;
import lotto.domain.roulette.RouletteResult;
import lotto.domain.roulette.WinningLotto;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGameController {
    private LottoGameService lottoGameService;
    private Roulette roulette;
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
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
        WinningLotto winningLotto = lottoGameService.getWinningLotto(winningNumber, bonusNumber);
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

    public List<Integer> getWinningNumber() {
        try {
           return  inputView.inputWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    public int getBonusNumber() {
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
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
