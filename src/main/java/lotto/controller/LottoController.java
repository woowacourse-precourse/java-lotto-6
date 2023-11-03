package lotto.controller;

import lotto.domain.Validate;
import lotto.view.InputView;

public class LottoController {
    Validate validate = new Validate();
    InputView inputView = new InputView();

    public long inputBuyLottoPrice() {
        long price = 0;
        String inputPrice = inputView.inputMessageHowMuchPrice();
        while (true) {
            price = validate.validateInputPrice(inputPrice);

            if (price >= 1) {
                break;
            }

            inputPrice = inputView.inputMessageHowMuchPrice();
        }

        return price;
    }
}
