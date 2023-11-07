package lotto;

import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.view.LottoViewImpl;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoView lottoView = new LottoViewImpl();
        LottoController lottoController = new LottoController(lottoService, lottoView);
        lottoController.start();
    }
}
