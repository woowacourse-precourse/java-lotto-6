package lotto;

import lotto.converter.ConvertService;
import lotto.lotto.LottoController;
import lotto.lotto.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new ConvertService(), new LottoView());
        lottoController.startLotto();
    }
}
