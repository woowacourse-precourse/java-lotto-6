package lotto;

import lotto.domain.Controller.LottoController;
import lotto.domain.Model.LottoMaker;
import lotto.domain.View.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView view = new LottoView();
        LottoMaker lottoMaker = new LottoMaker();
        LottoController controller = new LottoController(view, lottoMaker);

        controller.run();
    }
}
