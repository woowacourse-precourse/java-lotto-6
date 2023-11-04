package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String ENTER_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ENTER_WINNING_LOTTO_TICKET_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String scanBudget() {
        while (true) {
            try {
                System.out.println(ENTER_BUDGET_MESSAGE);
                String userInput = scanRawInput();
                inputValidator.validateBudgetInput(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String scanWinningNumbers() {
        while (true) {
            try {
                System.out.println(ENTER_WINNING_LOTTO_TICKET_MESSAGE);
                String userInput = scanRawInput();
                inputValidator.validateLottoTicketInput(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String scanBonusNumber() {
        while (true) {
            try {
                System.out.println(ENTER_BONUS_NUMBER_MESSAGE);
                String userInput = scanRawInput();
                inputValidator.validateBonusNumberInput(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String scanRawInput() {
        return Console.readLine();
    }
}
