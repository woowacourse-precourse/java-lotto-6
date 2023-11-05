package lotto.view;

import static lotto.view.constants.OutputMessage.INPUT_PURCHASE_PRICE_MESSAGE;
import static lotto.view.constants.OutputMessage.INPUT_WINNING_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Parser;
import lotto.view.validator.LottoNumberValidator;
import lotto.view.validator.PurchasePriceValidator;

public class InputView {
    private InputView() {
    }

    public static int inputPurchasePrice() {
        String inputPrice;
        do {
            OutputView.printMessage(INPUT_PURCHASE_PRICE_MESSAGE.getMessage());
            inputPrice = Console.readLine();
        } while (!PurchasePriceValidator.validatePurchasePrice(inputPrice));
        return Parser.parseInt(inputPrice);
    }

    public static List<Integer> inputWinningNumber() {
        String inputNumber;
        do {
            OutputView.printMessage(INPUT_WINNING_NUMBER_MESSAGE.getMessage());
            inputNumber = Console.readLine();
        } while (!LottoNumberValidator.validateLottoNumber(inputNumber));
        return LottoNumberValidator.parseLottoNumber(inputNumber);
    }
}
