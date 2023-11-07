package lotto;

import java.util.List;
import lotto.config.InputConfiguration;
import lotto.controller.IssueController;
import lotto.domain.Purchase;
import lotto.domain.vo.BonusNumber;
import lotto.domain.vo.TotalAmount;
import lotto.domain.vo.WinningNumbers;
import lotto.util.handler.InputHandler;

public class Launcher {
    public static void run() {
        // 금액 입력 처리
        InputHandler<Integer> amountInputHandler = InputConfiguration.createAmountInputHandler();
        int amount = amountInputHandler.processInput();
        TotalAmount totalAmount = TotalAmount.from(amount);
        Purchase purchase = Purchase.from(totalAmount);

        // 로또 발급
        IssueController issueController = IssueController.from(purchase);
        issueController.issueTickets();

        // 당첨 번호 입력 처리
        InputHandler<List<Integer>> winningNumbersInputHandler = InputConfiguration.createWinningNumbersInputHandler();
        List<Integer> winningNumbersList = winningNumbersInputHandler.processInput();
        WinningNumbers winningNumbers = WinningNumbers.from(winningNumbersList);

        InputHandler<Integer> bonusNumberInputHandler = InputConfiguration.createBonusNumberInputHandler(winningNumbers);
        int number = bonusNumberInputHandler.processInput();
        BonusNumber bonusNumber = BonusNumber.from(number);
    }
}
