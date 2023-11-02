package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validator.Validator;
import lotto.view.InputView;

public class InputController {
    public static String scanBudget() {
        while (true) {
            try {
                System.out.println(InputView.enterBudgetMessage());
                String userInput = Console.readLine();
                Validator.validateBudgetInput(userInput);
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
                Validator.validateLottoTicketInput(userInput);
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
                Validator.validateBonusNumberInput(winningLottoTicket, userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
