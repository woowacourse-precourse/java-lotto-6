package lotto.controller.userIO;


import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.view.InputView;

public class InputController {
    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputController(InputView inputView, InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        this.inputView = inputView;
    }

    public String scanBudget() {
        while (true) {
            try {
                System.out.println(inputView.enterBudgetMessage());
                String userInput = Console.readLine();
                inputValidator.validateBudgetInput(userInput);
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
                inputValidator.validateLottoTicketInput(userInput);
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
                inputValidator.validateBonusNumberInput(winningLottoTicket, userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
