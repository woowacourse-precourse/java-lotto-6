package lotto;

import lotto.controller.LottoController;
import lotto.util.StringUtil;
import lotto.util.TypeConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(inputView(), outputView());
        lottoController.run();
    }

    private static InputView inputView() {
        return new InputView(new TypeConverter());
    }

    private static OutputView outputView() {
        return new OutputView(new StringUtil());
    }
}
