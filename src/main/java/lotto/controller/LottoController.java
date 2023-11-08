package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoBonusPair;
import lotto.model.PublishedLotto;
import lotto.service.CalculateProfitService;
import lotto.service.ConfirmWinningService;
import lotto.service.InputService;
import lotto.service.PublishLottoService;
import lotto.service.Service;
import lotto.view.LottoOutputView;
import lotto.view.View;

public class LottoController implements Controller {
    private final LottoOutputView lottoOutputView;
    private final InputService inputService;
    private final PublishLottoService publishLottoService;
    private final ConfirmWinningService confirmWinningService;
    private final CalculateProfitService calculateProfitService;

    LottoController(final View lottoInputView, final View lottoOutputView) {
        this.lottoOutputView = (LottoOutputView) lottoOutputView;
        inputService = (InputService) Service.generateInputService(lottoInputView);
        publishLottoService = (PublishLottoService) Service.generatePublishLottoService();
        confirmWinningService = (ConfirmWinningService) Service.generateConfirmWinningService();
        calculateProfitService = (CalculateProfitService) Service.generateCalculateProfitService();
    }

    /**
     * 프로그램 시작 메서드
     */
    public void programStart() {
        Integer money = getMoneyInput();
        PublishedLotto publishedLotto = getPublishedLotto(money);
        LottoBonusPair winnerNumberPair = getWinnerNumberPair();
        Long totalReward = getTotalReward(publishedLotto, winnerNumberPair);
        calculateProfit(money, totalReward);
    }

    private Integer getMoneyInput() {
        return inputService.getInputMoney();
    }

    private PublishedLotto getPublishedLotto(final Integer money) {
        return publishLottoService.getPublishedLotto(money, lottoOutputView);
    }

    private LottoBonusPair getWinnerNumberPair() {
        Lotto winnerNumber = inputService.getInputWinnerNumbers();
        return inputService.getLottoBonusPair(winnerNumber);
    }

    private Long getTotalReward(final PublishedLotto publishedLotto, final LottoBonusPair winnerNumberPair) {
        confirmWinningService.confirmWinning(publishedLotto, winnerNumberPair, lottoOutputView);
        return confirmWinningService.getTotalReward();
    }

    private void calculateProfit(final Integer money, final Long totalReward) {
        calculateProfitService.calculateProfit(money, totalReward, lottoOutputView);
    }
}
