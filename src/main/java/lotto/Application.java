package lotto;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        OutputView.askAmountForLotto();
        OutputView.repeatGenerateRandomLotto();
    }
}
