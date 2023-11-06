package lotto;

import java.util.List;
import lotto.controller.AmountInputController;
import lotto.controller.IssueController;
import lotto.controller.WinningNumbersInputController;
import lotto.domain.Purchase;
import lotto.domain.vo.TotalAmount;
import lotto.domain.vo.WinningNumbers;
import lotto.util.parser.AmountParser;
import lotto.util.parser.InputParser;
import lotto.util.parser.WinningNumbersParser;
import lotto.util.validator.AmountValidator;
import lotto.util.validator.InputValidator;
import lotto.util.validator.WinningNumbersValidator;
import lotto.view.facade.AmountViewFacade;
import lotto.view.facade.ViewFacade;
import lotto.view.facade.WinningNumbersViewFacade;

public class Application {
    public static void main(String[] args) {
        TotalAmount totalAmount = proceedInputAmount();
        Purchase purchase = createPurchase(totalAmount);
        issueTickets(purchase);
        WinningNumbers winningNumbers = proceedInputWinningNumbers();
    }
    private static TotalAmount proceedInputAmount() {
        InputParser<Integer> parser = new AmountParser();
        InputValidator<Integer> validator = new AmountValidator();
        ViewFacade viewFacade = new AmountViewFacade();
        AmountInputController amountInputController = new AmountInputController(parser, validator, viewFacade);
        return amountInputController.inputValid();
    }

    private static Purchase createPurchase(TotalAmount totalAmount) {
        return Purchase.from(totalAmount);
    }

    private static void issueTickets(Purchase purchase) {
        IssueController issueController = IssueController.from(purchase);
        issueController.issueTickets();
    }

    private static WinningNumbers proceedInputWinningNumbers() {
        InputParser<List<Integer>> parser = new WinningNumbersParser();
        InputValidator<List<Integer>> validator = new WinningNumbersValidator();
        ViewFacade viewFacade = new WinningNumbersViewFacade();
        WinningNumbersInputController winningNumberInputController = new WinningNumbersInputController(parser, validator, viewFacade);
        return winningNumberInputController.inputValid();
    }
}
