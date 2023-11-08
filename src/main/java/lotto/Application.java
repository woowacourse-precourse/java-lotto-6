package lotto;

import lotto.controller.LottoController;
import lotto.service.RandomNumbers;
import lotto.service.RandomNumbersImpl;
import lotto.utils.Validation;
import lotto.utils.ValidationImpl;
import lotto.view.InputView;
import lotto.view.InputViewImpl;

public class Application {
    public static void main(String[] args) {
        Validation validation = new ValidationImpl();
        RandomNumbers randomNumbers = new RandomNumbersImpl();
        InputView inputView = new InputViewImpl(validation);
        LottoController controller = new LottoController(randomNumbers, inputView);
        controller.run();
    }
}
