package lotto.controller;

import java.util.List;
import lotto.domain.Validate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    Validate validate = new Validate();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
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

    public List<Integer> inputWinnerNumbers() {
        List<Integer> result;
        String inputNumbers = inputView.inputMessageWinnerNumbers();
        while (true) {
            result = validate.validateWinnerNumbers(inputNumbers);

            if (!result.contains(-1)) {
                break;
            }

            inputNumbers = inputView.inputMessageWinnerNumbers();
        }

        return result;
    }
}
