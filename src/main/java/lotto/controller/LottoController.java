package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.User;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.OutputView;

public class LottoController {

    private User user;

    public void run() {
        User user = registerUser();
    }

    private int readBudgetOfUser() throws IllegalArgumentException {
        try {
            OutputView.println(Messages.BUDGET_INPUT_MESSAGE);
            int budget = Parser.stringToInt(InputView.read());
            LottoTicket.validateAffordability(budget);
            return budget;
        } catch (IllegalArgumentException e) {
            return readBudgetOfUser();
        }
    }

    private User registerUser() {
        int budget = readBudgetOfUser();
        return new User(budget);
    }


}
