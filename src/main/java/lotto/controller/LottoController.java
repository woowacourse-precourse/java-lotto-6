package lotto.controller;

import java.util.List;
import lotto.exception.ExceptionHandler;
import lotto.model.Lotto;
import lotto.model.LottoGameHandler;
import lotto.model.Player;
import lotto.model.WinningTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameHandler lottoGameHandler = new LottoGameHandler();
    ExceptionHandler exceptionHandler = new ExceptionHandler();
    Player player = new Player();

    public void start() {

        WinningTicket winningTicket;
        List<Lotto> lottos;


        int purchaseQuantity = inputView.lottoPurchaseAmount();

        lottos = player.purchaseLotto(purchaseQuantity);

        outputView.lottoTickets(lottos);

        List<Integer> winningNum = inputView.winningNumbers();

        int bonusNum = inputView.bonusNumber();

        winningTicket = lottoGameHandler.createWinningTicket(winningNum, bonusNum);

        List<Integer> rankResult = lottoGameHandler.checkWinningResult(lottos, winningTicket);

        outputView.winningRecords(rankResult);

        float rateOfReturn = lottoGameHandler.calculatePrizes(purchaseQuantity, rankResult);

        outputView.prizesSummary(rateOfReturn);



    }

}
