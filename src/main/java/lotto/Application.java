package lotto;

import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        LottoValidation lottoValidation = new LottoValidation();

        IOPurchaseAmount(outputView, inputView, lottoValidation);
    }

    private static void IOPurchaseAmount(OutputView outputView, InputView inputView, LottoValidation lottoValidation) {
        outputView.printInputPurchaseAmountMessage();
        while (true) {
            try {
                inputView.readPurchaseAmount(lottoValidation);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
