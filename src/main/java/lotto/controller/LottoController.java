package lotto.controller;

import lotto.controller.dto.input.BonusBallDto;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.controller.dto.input.WinningLottoNumbersDto;
import lotto.controller.dto.output.PurchasedLottosDto;
import lotto.controller.dto.output.WinningLottoResultDto;
import lotto.model.lotto.BonusBall;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import lotto.model.purchase.LottoPurchase;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoWinningStatisticsService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoPurchaseService lottoPurchaseService;
    private final LottoWinningStatisticsService lottoWinningStatisticsService;
    private final LottoView lottoView;

    public LottoController(LottoPurchaseService lottoPurchaseService,
                           LottoWinningStatisticsService lottoWinningStatisticsService,
                           LottoView lottoView) {
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoWinningStatisticsService = lottoWinningStatisticsService;
        this.lottoView = lottoView;
    }

    public void run() {
        try {
            LottoPurchase lottoPurchase = purchaseLotto();
            WinningLotto winningLotto = getWinningLotto();
            calculateResult(lottoPurchase, winningLotto);
        } catch (Exception e) {
            lottoView.showError(e.getMessage());
        } finally {
            lottoView.release();
        }
    }

    private LottoPurchase purchaseLotto() {
        LottoPurchase lottoPurchase = null;
        while (lottoPurchase == null) {
            try {
                LottoPurchaseAmountDto lottoPurchaseAmountDto = lottoView.inputLottoPurchaseAmount();
                lottoPurchase = lottoPurchaseService.purchase(lottoPurchaseAmountDto);
            } catch (IllegalArgumentException e) {
                lottoView.showError(e.getMessage());
            }
        }
        lottoView.showPurchasedLottos(new PurchasedLottosDto(lottoPurchase.lottos()));
        return lottoPurchase;
    }

    private WinningLotto getWinningLotto() {
        WinningLotto winningLotto = null;
        while (winningLotto == null) {
            try {
                WinningLottoNumbersDto winningLottoNumbersDto = lottoView.inputWinningLottoNumbers();
                BonusBallDto bonusBallDto = lottoView.inputBonusBallNumber();

                Lotto lotto = new Lotto(winningLottoNumbersDto.toIntegerList());
                BonusBall bonusBall = new BonusBall(bonusBallDto.toInt());
                winningLotto = new WinningLotto(lotto, bonusBall);
            } catch (IllegalArgumentException | IllegalStateException e) {
                lottoView.showError(e.getMessage());
            }
        }
        return winningLotto;
    }

    private void calculateResult(LottoPurchase lottoPurchase, WinningLotto winningLotto) {
        WinningLottoResultDto winningLottoResultDto =
                lottoWinningStatisticsService.getWinningStatistics(lottoPurchase, winningLotto);
        lottoView.showWinningLottoResult(winningLottoResultDto);
    }
}
