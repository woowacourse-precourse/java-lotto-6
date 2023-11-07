package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.LottoResut;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final LottoController instance = new LottoController();

    public static LottoController getInstance() {
        return instance;
    }

    private LottoController() {
    }

    private final LottoService lottoService = LottoService.getInstance();

    public void run() {
        OutputView.printBuyPrice();
        int buyAmount = InputView.getBuyAmount();
        OutputView.printBuyAmount(buyAmount);
        List<Lotto> userLottos = lottoService.getLottoNumbers(buyAmount);
        OutputView.printUserLottos(userLottos);
        OutputView.printRequireMessage();
        List<Integer> winningNumber = InputView.getWinningNumber();
        OutputView.printRequireBonusMessage();
        int bonusNumber = InputView.getBonusNumber(winningNumber);
        Map<Rank, Integer> lottoResult = lottoService.calculateResult(userLottos, winningNumber, bonusNumber);
        OutputView.printLottoResult(lottoResult);
        String revenueRate = lottoService.calculateRevenueRate(buyAmount, lottoResult);
        OutputView.printRevenueRate(revenueRate);
    }
}
