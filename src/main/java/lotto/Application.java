package lotto;

import java.util.List;
import lotto.controller.AmountInputController;
import lotto.controller.IssueController;
import lotto.controller.WinningNumbersInputController;
import lotto.domain.Purchase;
import lotto.domain.vo.TotalAmount;
import lotto.util.parser.AmountParser;
import lotto.util.parser.InputParser;
import lotto.util.parser.WinningNumbersParser;
import lotto.util.validator.AmountValidator;
import lotto.util.validator.InputValidator;
import lotto.util.validator.WinningNumbersValidator;

public class Application {
    public static void main(String[] args) {
        InputParser<Integer> amountParser = new AmountParser();
        InputValidator<Integer> amountValidator = new AmountValidator();
        AmountInputController amountInputController = new AmountInputController(amountParser, amountValidator);
        TotalAmount totalAmount = amountInputController.inputValid();

        Purchase purchase = Purchase.from(totalAmount);
        IssueController issueController = IssueController.from(purchase);
        issueController.issueTickets();

        InputParser<List<Integer>> winningNumberParser = new WinningNumbersParser();
        InputValidator<List<Integer>> winningNumbersValidator = new WinningNumbersValidator();
        WinningNumbersInputController winningNumberInputController = new WinningNumbersInputController(
                winningNumberParser, winningNumbersValidator);
        winningNumberInputController.inputValid();
    }
}
