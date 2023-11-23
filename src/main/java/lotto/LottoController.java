package lotto;

import lotto.domain.lotto.LottoService;
import lotto.domain.lotto.entity.Lottos;
import lotto.domain.lotto.generator.RandomLottoGenerator;
import lotto.exception.RetryExceptionHandler;
import lotto.view.InputView;

public class LottoController {
    RetryExceptionHandler handler = new RetryExceptionHandler();
    InputView inputView;
    //OutputView outputView;

    LottoService lottoService = new LottoService(new RandomLottoGenerator());

    void run() {
        purchaseLotto();
    }

    private Lottos purchaseLotto() {
        //1. 금액 입력
        //2. 로또 구매
        //3. 로또 반환
        return handler.get(
                () -> {
                    int purchaseMoney = inputView.getPurchaseMoney();
                    return lottoService.purchaseLottos(purchaseMoney);
                    //todo 출력을 다른 메서드로 나누거나, 아니면 여기서 한 번에 출력하고 넘어가거나
                });
    }

    private void getPurchaseMoney() {
        inputView.getPurchaseMoney();
    }
}
