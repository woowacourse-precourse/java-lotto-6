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
    private final LottoTickets lottoTickets;

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

        WinningLotto winningLotto = getWinningLotto();
        HashMap<Result, Integer> resultMap = lottoTickets.calculateWinningLotto(winningLotto);
        outputView.printResult(resultMap, getScore(resultMap));
    }

    public double getScore(HashMap<Result, Integer> resultMap) {
        double sum = 0;
        int ticketCount = 0;
        for (Result result : resultMap.keySet()) {
            Integer ticketPieces = resultMap.get(result);
            sum += result.getPrizeMoney() * ticketPieces;
            ticketCount += ticketPieces;
        }

        int totalCost = ticketCount * TICKET_PRICE;
        return sum / totalCost * 100;
    }

    private WinningLotto getWinningLotto() {
        List<Integer> numbers = inputView.getWinningLottoNumbers();
        int bonusNumber = inputView.getWinningLottoBonusNumber();
        return new WinningLotto(numbers, bonusNumber);
    }

}
