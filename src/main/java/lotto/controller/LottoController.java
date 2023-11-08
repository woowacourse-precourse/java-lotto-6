package lotto.controller;

import lotto.domain.lotto.LottoDraw;

import lotto.domain.lotto.LottoPaper;
import lotto.domain.payment.Payment;
import lotto.domain.prize.Prize;
import lotto.domain.result.LottoResult;

import lotto.service.LottoPaperService;
import lotto.service.LottoPrizeService;
import lotto.service.LottoResultService;
import lotto.service.LottoService;

import lotto.view.OutputView;


public class LottoController {
    private final LottoService lottoService;
    private final LottoPaperService lottoPaperService;
    private final LottoResultService lottoResultService;
    private final LottoPrizeService lottoPrizeService;

    LottoController() {
        this.lottoService = new LottoService();
        this.lottoPaperService = new LottoPaperService();
        this.lottoResultService = new LottoResultService();
        this.lottoPrizeService = new LottoPrizeService();
    }

    public LottoPaper purchaseLottoPaper(final Payment payment) {
        LottoPaper lottoPaper = lottoPaperService.createLottoPaper(payment);
        OutputView.printLottoPaperMessage(lottoPaper);
        return lottoPaper;
    }

    public LottoDraw requestLottoDraw() {
        OutputView.printWinningDrawMessage();
        return lottoService.createLottoDraw();
    }

    public LottoResult evaluateLottoResult(
            final LottoPaper lottoPaper,
            final LottoDraw lottoDraw
    ) {
        LottoResult lottoResult = lottoResultService.createLottoResult(lottoPaper, lottoDraw);
        OutputView.printLottoResultMessage(lottoResult);
        return lottoResult;
    }

    public Prize calculatePrize(LottoResult lottoResult) {
        return lottoPrizeService.createPrize(lottoResult);
    }
}

