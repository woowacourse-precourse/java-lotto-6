package lotto;

import java.util.List;
import lotto.controller.IssueController;
import lotto.domain.Purchase;
import lotto.domain.vo.TotalAmount;
import lotto.domain.vo.WinningNumbers;
import lotto.processor.InputProcessor;
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
        Integer amount = processInput(new AmountParser(), new AmountValidator(), new AmountViewFacade());
        TotalAmount totalAmount = TotalAmount.from(amount);

        Purchase purchase = createPurchase(totalAmount);
        issueTickets(purchase);

        List<Integer> numbers = processInput(new WinningNumbersParser(), new WinningNumbersValidator(),
                new WinningNumbersViewFacade());
        WinningNumbers winningNumbers = WinningNumbers.from(numbers);
    }

    private static <T> T processInput(
            InputParser<T> parser,
            InputValidator<T> validator,
            ViewFacade viewFacade
    ) {
        InputProcessor<T> inputProcessor = new InputProcessor<>(
                parser,
                validator,
                viewFacade
        );
        return inputProcessor.process();
    }

    private static Purchase createPurchase(TotalAmount totalAmount) {
        return Purchase.from(totalAmount);
    }

    private static void issueTickets(Purchase purchase) {
        IssueController issueController = IssueController.from(purchase);
        issueController.issueTickets();
    }
}
