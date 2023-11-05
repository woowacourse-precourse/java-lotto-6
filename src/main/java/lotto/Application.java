package lotto;

import lotto.controller.InputController;
import lotto.domain.Purchase;
import lotto.domain.vo.TotalAmount;
import lotto.util.parser.AmountParser;
import lotto.util.parser.InputParser;
import lotto.util.validator.AmountValidator;
import lotto.util.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        InputParser<Integer> amountParser = new AmountParser();
        InputValidator<Integer> validator = new AmountValidator();
        InputController inputController = new InputController(amountParser, validator);

        TotalAmount totalAmount = inputController.tryInputValidAmount();
        Purchase purchase = Purchase.createFrom(totalAmount);
    }
}
