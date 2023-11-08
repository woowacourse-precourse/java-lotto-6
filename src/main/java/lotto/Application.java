package lotto;

import lotto.controller.LottoGameController;
import lotto.model.service.LottoHeadQuarter;
import lotto.model.service.LottoStore;
import lotto.model.service.RandomNumberGenerateStrategy;
import lotto.view.ErrorView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // 설정
        OutputView outputView = new OutputView();
        ErrorView errorView = new ErrorView();
        LottoStore lottoStore = new LottoStore(new RandomNumberGenerateStrategy());
        LottoHeadQuarter lottoHeadQuarter = new LottoHeadQuarter();
        LottoGameController controller = new LottoGameController(outputView, errorView, lottoStore, lottoHeadQuarter);
        // 실행
        controller.run();
    }
}
