package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Validator;
import lotto.view.InputView;

public class InputController {
    private final InputView inputView;
    private final Validator validator;

    public InputController(InputView inputView, Validator validator) {
        this.validator = validator;
        this.inputView = inputView;
    }

    public String scanBudget() {
        while (true) {
            try {
                System.out.println(inputView.enterBudgetMessage());
                String userInput = Console.readLine();
                validator.validateBudgetInput(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String scanWinningLottoTicket() {
        while (true) {
            try {
                System.out.println(inputView.enterWinningLottoTicket());
                String userInput = Console.readLine();
                validator.validateLottoTicketInput(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String scanBonusNumber(Lotto winningLottoTicket) {
        while (true) {
            try {
                System.out.println(inputView.enterBonusNumber());
                String userInput = Console.readLine();
                validator.validateBonusNumberInput(winningLottoTicket, userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
