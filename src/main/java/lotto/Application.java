package lotto;

import lotto.domain.Validate;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validate validate = new Validate();
        InputView inputView = new InputView();

        String inputPrice = inputView.inputMessageHowMuchPrice();
        final long PRICE = validate.validateInputPrice(inputPrice);

        System.out.println(PRICE);
    }
}
