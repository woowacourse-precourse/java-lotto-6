package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoBonusPair;
import lotto.model.PublishedLotto;
import lotto.service.CalculateProfitService;
import lotto.service.ConfirmWinningService;
import lotto.service.InputService;
import lotto.service.PublishLottoService;
import lotto.service.Service;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;
import lotto.view.View;

public class LottoController implements Controller {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final InputService inputService;
    private final PublishLottoService publishLottoService;
    private final ConfirmWinningService confirmWinningService;
    private final CalculateProfitService calculateProfitService;

    LottoController(View lottoInputView, View lottoOutputView) {
        this.lottoInputView = (LottoInputView) lottoInputView;
        this.lottoOutputView = (LottoOutputView) lottoOutputView;
        inputService = (InputService) Service.generateInputService();
        publishLottoService = (PublishLottoService) Service.generatePublishLottoService();
        confirmWinningService = (ConfirmWinningService) Service.generateConfirmWinningService();
        calculateProfitService = (CalculateProfitService) Service.generateCalculateProfitService();
    }

    public void programStart() {
        Integer money = getMoneyInput();

        PublishedLotto publishedLotto = getPublishedLotto(money);

        LottoBonusPair winnerNumberPair = getWinnerNumberPair();

        Long totalReward = getTotalReward(publishedLotto, winnerNumberPair);

        calculateProfit(money, totalReward);
    }

    private Integer getMoneyInput() {
        return inputService.getInputMoney(lottoInputView);
    }

    private PublishedLotto getPublishedLotto(Integer money) {
        return publishLottoService.getPublishedLotto(money, lottoOutputView);
    }

    private LottoBonusPair getWinnerNumberPair() {
        Lotto winnerNumber = inputService.getInputWinnerNumbers(lottoInputView);
        return inputService.getLottoBonusPair(winnerNumber, lottoInputView);
    }

    private Long getTotalReward(PublishedLotto publishedLotto, LottoBonusPair winnerNumberPair) {
        confirmWinningService.confirmWinning(publishedLotto, winnerNumberPair, lottoOutputView);
        return confirmWinningService.getTotalReward();
    }

    private void calculateProfit(Integer money, Long totalReward) {
        calculateProfitService.calculateProfit(money, totalReward, lottoOutputView);
    }
}
