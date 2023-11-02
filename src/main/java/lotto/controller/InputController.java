package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class InputController {
    public static String scanBudget() {
        while (true) {
            try {
                System.out.println(InputView.enterBudgetMessage());
                String userInput = Console.readLine();
                InputValidator.validateBudget(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String scanWinningLottoTicket() {
        while (true) {
            try {
                System.out.println(InputView.enterWinningLottoTicket());
                String userInput = Console.readLine();
                InputValidator.validateLottoTicket(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String scanBonusNumber(Lotto winningLottoTicket) {
        while (true) {
            try {
                System.out.println(InputView.enterBonusNumber());
                String userInput = Console.readLine();
                InputValidator.validateBonusNumber(winningLottoTicket, userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
