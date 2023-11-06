package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.Target;
import lotto.domain.WinningChecker;
import lotto.handler.UiHandler;

import java.util.List;

public class LottoGameController {
    private final UiHandler uiHandler;

    public LottoGameController(UiHandler uiHandler) {
        this.uiHandler = uiHandler;
    }

    public void run() {
        int payment = uiHandler.getAndValidatePayment();

        Customer customer = createCustomerAndBuyLottos(payment);
        uiHandler.printInfoOfLottos(customer);

        Target target = createTargetByTargetNumbersAndBonusNumber();

        customer.calculateResult(target);

        WinningChecker winningChecker = createWinningCheckerAndCheckWinning(customer);

        uiHandler.printWinningInfo(winningChecker);
        uiHandler.printRateOfProfit(customer, winningChecker);
    }

    private Customer createCustomerAndBuyLottos(int payment) {
        Customer customer = Customer.createCustomer(payment);
        customer.buyLottos();
        return customer;
    }

    private Target createTargetByTargetNumbersAndBonusNumber() {
        List<Integer> targetNumbers = uiHandler.getAndTargetNumbers();
        int bonusNumber = uiHandler.getAndValidateBonusNumber(targetNumbers);

        return Target.createTarget(targetNumbers, bonusNumber);
    }

    private static WinningChecker createWinningCheckerAndCheckWinning(Customer customer) {
        WinningChecker winningChecker = WinningChecker.createWinningChecker();
        winningChecker.checkWinning(customer);
        return winningChecker;
    }
}
