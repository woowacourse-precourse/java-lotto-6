package lotto.service;

import lotto.controller.InputController;
import lotto.controller.OutputController;
import lotto.model.LottoMachine;
import lotto.model.LottoRandomGenerator;
import lotto.model.LottoShop;
import lotto.model.Player;
import lotto.model.WinningLotto;

public class LottoGameService {
    private final InputController inputController;
    private final OutputController outputController;

    private LottoShop lottoShop;
    private Player player;

    public LottoGameService(InputController inputController, OutputController outputController) {
        LottoMachine lottoMachine = new LottoMachine(new LottoRandomGenerator());
        lottoShop = new LottoShop(lottoMachine);
        player = new Player();
        this.inputController = inputController;
        this.outputController = outputController;
    }

    public void run() {
        int budget = inputController.askBudget();
        player.setBudget(budget);
        player.buyLottoTickets(lottoShop);
        outputController.printLottoTicketsCount(player.getLottoTickets().size());
        outputController.printLottoTickets(player.getLottoTickets());

        WinningLotto winningLotto = inputController.askWinningLotto();
        player.calculateWinningLottoWithMine(winningLotto);
        outputController.printPrizeCounter(player.getWinningStatistics().getPrizeCounter());
        outputController.printRateOfReturn(player.getWinningStatistics().getRateOfReturn());
    }
}