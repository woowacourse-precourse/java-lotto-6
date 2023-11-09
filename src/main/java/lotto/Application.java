package lotto;

import lotto.controller.LottoGameController;
import lotto.model.service.LottoGameService;
import lotto.model.service.LottoStoreService;
import lotto.model.service.RandomNumberGenerateStrategy;
import lotto.view.ErrorView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // 설정
        OutputView outputView = new OutputView();
        ErrorView errorView = new ErrorView();
        LottoStoreService lottoStoreService = new LottoStoreService(new RandomNumberGenerateStrategy());
        LottoGameService lottoGameService = new LottoGameService();
        LottoGameController controller = new LottoGameController(outputView, errorView, lottoStoreService,
                lottoGameService);
        // 실행
        controller.run();
    }
}
