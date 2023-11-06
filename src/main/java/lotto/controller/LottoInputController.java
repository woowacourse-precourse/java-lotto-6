package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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
                System.out.println("구입금액을 입력해 주세요.");
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
                System.out.println("\n당첨 번호를 입력해 주세요.");
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
                System.out.println("\n보너스 번호를 입력해 주세요.");
                final String input = Console.readLine();
                return InputValidator.validateBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
