package lotto;

import lotto.controller.AmountInputController;
import lotto.controller.IssueController;
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
        AmountInputController amountInputController = new AmountInputController(amountParser, validator);

        TotalAmount totalAmount = amountInputController.InputValid();
        Purchase purchase = Purchase.from(totalAmount);

        IssueController issueController = IssueController.from(purchase);
        issueController.issueTickets();
    }
}
