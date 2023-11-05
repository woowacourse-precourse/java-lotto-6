package lotto.service;

import lotto.model.LottoTickets;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.util.Constants.TICKET_PRICE;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoTickets lottoTickets;

    public LottoMachine(RandomNumberGenerator numberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoTickets = new LottoTickets(numberGenerator);
    }

    public LottoMachine() {
        this(new LottoNumberGenerator());
    }

    public void start() {
        int lottoBudget = inputView.getLottoBudget();
        lottoTickets.createTicket(lottoBudget / TICKET_PRICE);
        outputView.printLottoTickets(lottoTickets.getLottoTickets());
    }

}
