package lotto;

import lotto.domain.Controller.LottoController;
import lotto.domain.Service.LottoMakingService;
import lotto.View.LottoInputView;
import lotto.View.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoInputView view = new LottoInputView();
        LottoMakingService lottoMakingService = new LottoMakingService();
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoController controller = new LottoController(view, lottoOutputView, lottoMakingService);

        controller.run();
    }
}
