package lotto;


import lotto.controller.LottoController;
import lotto.view.input.LottoNumberInputView;
import lotto.view.input.LottoShopInput;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new LottoShopInput(), new LottoNumberInputView(),
                new LottoBuyOutputView(), new LottoResultOutputView());

        lottoController.run();
    }
}
