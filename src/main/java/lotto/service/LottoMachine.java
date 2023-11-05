package lotto.service;

import lotto.WinningLotto;
import lotto.model.LottoTickets;
import lotto.model.Result;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

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

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        HashMap<Result, Integer> resultIntegerHashMap = lottoTickets.calculateWinningLotto(winningLotto);
        System.out.println(resultIntegerHashMap);
    }

}
