package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.Target;
import lotto.domain.WinningChecker;
import lotto.handler.InputHandler;
import lotto.message.GuideMessage;

import java.util.List;

public class LottoGameController {
    private final InputHandler inputHandler;

    public LottoGameController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        Customer customer = createCustomerAndBuyLottos();

        Target target = createTargetNumbersAndBonusNumber();

        customer.calculateResult(target);

        calculateAndPrintWinning(customer);
    }

    private Customer createCustomerAndBuyLottos() {
        System.out.println(GuideMessage.GET_PAYMENT_REQUEST_MESSAGE);
        int payment = inputHandler.getPayment();

        Customer customer = Customer.createCustomer(payment);
        customer.buyLottos();
        customer.printInfoOfLottos();

        return customer;
    }

    private Target createTargetNumbersAndBonusNumber() {
        System.out.println(GuideMessage.GET_TARGET_NUMBERS_REQUEST_MESSAGE);
        List<Integer> targetNumbers = inputHandler.getTargetNumbers();

        System.out.println(GuideMessage.GET_BONUS_NUMBER_REQUEST_MESSAGE);
        int bonusNumber = inputHandler.getAndValidateBonusNumber(targetNumbers);

        return Target.createTarget(targetNumbers, bonusNumber);
    }

    private static void calculateAndPrintWinning(Customer customer) {
        WinningChecker winningChecker = WinningChecker.createWinningChecker();
        winningChecker.checkWinning(customer);
        winningChecker.printWinningInfo();
        winningChecker.printRateOfProfit(customer);
    }

}
