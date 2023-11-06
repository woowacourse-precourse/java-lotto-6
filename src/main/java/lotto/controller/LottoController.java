package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Store;
import lotto.domain.User;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.OutputView;

public class LottoController {

    private User user;
    private final Store store;

    public LottoController(Store store) {
        this.store = store;
    }

    public void run() {
        int budget = readBudgetOfUser();
        LottoTickets lottoTickets = store.sellLottoTickets(budget);

        user = new User(budget, lottoTickets);
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

}
