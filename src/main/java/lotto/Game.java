package lotto;

import java.util.List;
import java.util.Map;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    private final InputView inputView = new InputView();
    private final LottoMaker lottoMaker = new LottoMaker();

    private final OutputView outputView = new OutputView();

    private final WinningAnalyzer winningAnalyzer = new WinningAnalyzer();


    public void run(){
        int money = inputView.getMoney();
        int lottoTicketCount = lottoMaker.calculateLottoTicketCount(money);
        List<Lotto> lottos = lottoMaker.makeLottoTickets(lottoTicketCount);

        System.out.println();
        outputView.printLottoTicketCount(lottos);
        outputView.printLottoTickets(lottos);
        WinningLotto winningLotto = inputView.getWinningLotto();
        Map<Rank, Integer> winningResult = winningAnalyzer.compareAllLotto(lottos, winningLotto);
        outputView.printWinningResult(winningResult);

    }
}
