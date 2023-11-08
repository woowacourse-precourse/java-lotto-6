package lotto.controller;

import static lotto.view.Messages.AMOUNT_OF_TICKET_MESSAGE;
import static lotto.view.Messages.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.view.Messages.COMMA;
import static lotto.view.Messages.WINNING_LOTTO_INPUT_MESSAGE;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Ranking;
import lotto.domain.RankingResult;
import lotto.domain.Store;
import lotto.domain.WinningLotto;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.OutputView;

public class LottoController {

    private int budget;
    private LottoTickets lottoTickets;
    private final Store store;
    private WinningLotto winningLotto;

    public LottoController(Store store) {
        this.store = store;
    }

    public void run() {
        budget = readBudget();
        lottoTickets = store.sellLottoTickets(budget);
        printLottoTickets();
        winningLotto = readWinningLotto();
        RankingResult result = calculateCountOfRankings();
        OutputView.printResult(result);
        OutputView.printProfitRate(calculateProfitRate(result));
    }

    private float calculateProfitRate(final RankingResult result) {
        return result.calculateProfit() / budget;
    }

    private RankingResult calculateCountOfRankings() {
        List<Ranking> rankings = lottoTickets.calculateRanking(winningLotto);

        RankingResult result = new RankingResult();

        for (Ranking ranking : rankings) {
            result.updateResult(ranking);
        }

        return result;
    }

    private WinningLotto readWinningLotto() {
        try {
            List<Integer> winningLottoNumbers = readWinningLottoNumbers();
            int bonusNumber = readBonusNumber();
            return new WinningLotto(winningLottoNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            return readWinningLotto();
        }
    }

    private int readBonusNumber() {
        OutputView.println(BONUS_NUMBER_INPUT_MESSAGE);
        return Parser.stringToInteger(InputView.read());
    }

    private List<Integer> readWinningLottoNumbers() {
        OutputView.println(WINNING_LOTTO_INPUT_MESSAGE);
        return Parser.stringToIntegerListWithSplittingBySeparator(InputView.read(), COMMA);

    }

    private void printLottoTickets() {
        OutputView.println(lottoTickets.getSizeOfLottoTickets() + AMOUNT_OF_TICKET_MESSAGE);
        OutputView.println(lottoTickets.toString());
    }

    private int readBudget() throws IllegalArgumentException {
        try {
            OutputView.println(Messages.BUDGET_INPUT_MESSAGE);
            int budget = Parser.stringToInteger(InputView.read());
            LottoTicket.validateAffordability(budget);
            return budget;
        } catch (IllegalArgumentException e) {
            return readBudget();
        }
    }

}
