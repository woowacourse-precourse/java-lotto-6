package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
        // 입력받기(제어단) -> 사용자 입력

        // 당첨번호, 보너스 번호 입력받기
        // 결과 계산
        // 결과 출력하기
    }

    public LottoPurchase buyLottos() {
        int money = inputView.inputMoney();
        return LottoPurchase.of(money);
    }

    public void showLottoCount(LottoPurchase lottoPurchase) {
        int count = lottoPurchase.getCount();
        outputView.outputLottoCount(count);
    }

    public void showLottosNumber(Lottos lottos) {
        List<Lotto> boughtLottos = lottos.getLottos();
        outputView.outputLottosNumber(boughtLottos);
    }

}
