package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.Rank;
import lotto.domain.WinningAnalyzer;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    private final InputView inputView;
    private final LottoMaker lottoMaker;

    private final OutputView outputView;

    private final WinningAnalyzer winningAnalyzer;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoMaker = new LottoMaker();
        winningAnalyzer = new WinningAnalyzer();
    }


    public void run() {
        int money = inputView.getMoney();
        int lottoTicketCount = lottoMaker.calculateLottoTicketCount(money);
        List<Lotto> lottos = lottoMaker.makeLottoTickets(lottoTicketCount);

        outputView.printLottoTicketCount(lottos);
        outputView.printLottoTickets(lottos);
        WinningLotto winningLotto = inputView.getWinningLotto();
        Map<Rank, Integer> winningResult = winningAnalyzer.compareAllLotto(lottos, winningLotto);
        outputView.printWinningResult(winningResult);
        outputView.printRate(winningAnalyzer.calculateRate(winningResult, money));
    }
}
