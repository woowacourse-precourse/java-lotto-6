package lotto.controller;

import lotto.controller.dto.input.BonusBallDto;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.controller.dto.input.WinningLottoNumbersDto;
import lotto.controller.dto.output.PurchasedLottosDto;
import lotto.controller.dto.output.WinningLottoResultDto;
import lotto.model.lotto.BonusBall;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningTicket;
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
            WinningTicket winningTicket = getWinningTicket();
            calculateResult(lottoPurchase, winningTicket);
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

    private WinningTicket getWinningTicket() {
        WinningTicket winningTicket = null;
        while (winningTicket == null) {
            try {
                Lotto winningLotto = getWinningLotto();
                BonusBall bonusBall = getBonusBall();
                winningTicket = new WinningTicket(winningLotto, bonusBall);
            } catch (IllegalArgumentException | IllegalStateException e) {
                lottoView.showError(e.getMessage());
            }
        }
        return winningTicket;
    }

    private Lotto getWinningLotto() {
        Lotto winningLotto = null;
        while (winningLotto == null) {
            try {
                WinningLottoNumbersDto winningLottoNumbersDto = lottoView.inputWinningLottoNumbers();
                winningLotto = new Lotto(winningLottoNumbersDto.toIntegerList());
            } catch (IllegalArgumentException e) {
                lottoView.showError(e.getMessage());
            }
        }
        return winningLotto;
    }

    private BonusBall getBonusBall() {
        BonusBall bonusBall = null;
        while (bonusBall == null) {
            try {
                BonusBallDto bonusBallDto = lottoView.inputBonusBallNumber();
                bonusBall = new BonusBall(bonusBallDto.toInt());
            } catch (IllegalArgumentException e) {
                lottoView.showError(e.getMessage());
            }
        }
        return bonusBall;
    }

    private void calculateResult(LottoPurchase lottoPurchase, WinningTicket winningTicket) {
        WinningLottoResultDto winningLottoResultDto =
                lottoWinningStatisticsService.getWinningStatistics(lottoPurchase, winningTicket);
        lottoView.showWinningLottoResult(winningLottoResultDto);
    }
}
