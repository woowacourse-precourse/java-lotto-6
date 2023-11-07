package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.InputView;

public class LottoInputController {
    private static final LottoInputController inputController = new LottoInputController();

    private LottoInputController() {
    }

    public static LottoInputController getInstance() {
        return inputController;
    }

    public int getUserInputForAmount() {
        while (true) {
            try {
                InputView.printPurchaseMoneyMessage();
                String input = Console.readLine();
                return InputValidator.validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getUserInputForWinningNumbers() {
        while (true) {
            try {
                InputView.printWinningNumbersMessage();
                final String input = Console.readLine();
                return InputValidator.validateWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getUserInputForBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                InputView.printWinningBonusNumberMessage();
                final String input = Console.readLine();
                Console.close();
                return InputValidator.validateBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
