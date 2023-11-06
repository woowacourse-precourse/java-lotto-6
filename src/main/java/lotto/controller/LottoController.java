package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Store;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.OutputView;

public class LottoController {

    private int budget;
    private LottoTickets lottoTickets;
    private final Store store;

    public LottoController(Store store) {
        this.store = store;
    }

    public void run() {
        int budget = readBudget();
        LottoTickets lottoTickets = store.sellLottoTickets(budget);
    }

    private int readBudget() throws IllegalArgumentException {
        try {
            OutputView.println(Messages.BUDGET_INPUT_MESSAGE);
            int budget = Parser.stringToInt(InputView.read());
            LottoTicket.validateAffordability(budget);
            return budget;
        } catch (IllegalArgumentException e) {
            return readBudget();
        }
    }

}
