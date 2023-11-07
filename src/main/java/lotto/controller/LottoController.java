package lotto.controller;

import lotto.domain.constant.LottoPrize;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        generateLottos();

        generateWinningLotto();

        getLottoResults();
    }

    public void generateLottos() {
        try {
            String moneyInput = inputView.inputMoney();
            List<List<Integer>> lottos = lottoService.generateLottos(moneyInput);
            int purchaseLottoCount = lottoService.getPurchaseLottoCount();

            outputView.printPurchaseCount(purchaseLottoCount);
            outputView.printGenerateLottos(lottos);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());

            generateLottos();
        }
    }

    public void generateWinningLotto() {
        try {
            List<String> lottoInput = inputView.inputWinningNumbers();
            String bonusInput = inputView.inputBonusNumber();

            lottoService.createWinningLotto(lottoInput, bonusInput);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());

            generateWinningLotto();
        }
    }

    public void getLottoResults() {
        try {
            Map<LottoPrize, Integer> lottoPrizeHistory = lottoService.getLottoResults();
            double profitRate = lottoService.getProfitRate();

            outputView.printLottoResults(lottoPrizeHistory);
            outputView.printProfitRate(profitRate);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());

            getLottoResults();
        }
    }
}
