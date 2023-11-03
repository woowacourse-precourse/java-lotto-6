package lotto;

import lotto.domain.Controller.LottoController;
import lotto.domain.Model.LottoMaker;
import lotto.domain.View.LottoInputView;
import lotto.domain.View.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoInputView view = new LottoInputView();
        LottoMaker lottoMaker = new LottoMaker();
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoController controller = new LottoController(view, lottoOutputView,lottoMaker);

        controller.run();
    }
}
