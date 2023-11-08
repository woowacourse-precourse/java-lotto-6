package lotto.controller;

import java.util.EnumMap;
import lotto.model.Lotties;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputService inputService;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoGameController() {
        this.inputService = new InputService(new InputView());
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void start() {
        int money = inputService.getMoney();
        Lotties purchasedLotties = lottoService.buyLotties(money);
        outputView.printPurchasedLotties(purchasedLotties.getLotties());

        Lotto winningLotto = inputService.getWinningNumbers();
        int bonusNumber = inputService.getBonusNumber();

        EnumMap<Rank, Integer> rankCounts = lottoService.getWinningStatistics(purchasedLotties, winningLotto,
                bonusNumber);
        outputView.printWinningStatistics(rankCounts);

        double profitability = lottoService.getProfitability(rankCounts, money);
        outputView.printProfitability(profitability);
    }


}
