package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.model.domain.Rank;
import lotto.model.handler.GameHandler;
import lotto.model.domain.Player;
import lotto.model.domain.WinningTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GameHandler gameHandler = new GameHandler();
    Player player = new Player();

    public void start() {

        player.purchaseLotto(inputView.lottoPurchaseCost());

        outputView.lottoTickets(player.getLottos());

        List<Integer> winningNum = inputView.winningNumbers();

        int bonusNum = inputView.bonusNumber();

        WinningTicket winningTicket = gameHandler.createWinningTicket(winningNum, bonusNum);

        EnumMap<Rank, Integer> winningStatics = gameHandler.checkWinningResult(player.getLottos(),
            winningTicket);

        outputView.winningRecords(winningStatics);

        float rateOfReturn = gameHandler.calculatePrizes(player.getPurchaseCost(), winningStatics);

        outputView.prizesSummary(rateOfReturn);
    }
}
