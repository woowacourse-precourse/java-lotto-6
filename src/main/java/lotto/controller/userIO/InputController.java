package lotto.controller.userIO;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.utils.Parser;
import lotto.view.InputView;

public class InputController {
    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputController(InputView inputView, InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        this.inputView = inputView;
    }

    public int getBudget() {
        return Integer.parseInt(scanBudget());
    }

    private String scanBudget() {
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

    public WinningLotto getWinningLottoTicket() {
        String userInput = scanWinningLottoTicket();

        List<Integer> lotto = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(number -> lotto.add(Integer.parseInt(number)));
        Lotto winningLottoTicket = new Lotto(lotto);

        int bonusNumber = Integer.parseInt(
                scanBonusNumber(winningLottoTicket)
        );
        return new WinningLotto(winningLottoTicket, bonusNumber);
    }

    private String scanWinningLottoTicket() {
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

    private String scanBonusNumber(Lotto winningLottoTicket) {
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
