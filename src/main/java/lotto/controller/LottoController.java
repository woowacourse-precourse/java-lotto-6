package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoBonusPair;
import lotto.model.PublishedLottos;
import lotto.service.CalculateProfitService;
import lotto.service.ConfirmWinningService;
import lotto.service.InputService;
import lotto.service.PublishLottoService;
import lotto.service.Service;
import lotto.view.View;

public class LottoController implements Controller {
    private final InputService inputService;
    private final PublishLottoService publishLottoService;
    private final ConfirmWinningService confirmWinningService;
    private final CalculateProfitService calculateProfitService;

    LottoController(View lottoInputView, View lottoOutputView) {
        inputService = (InputService) Service.generateInputService(lottoInputView);
        publishLottoService = (PublishLottoService) Service.generatePublishLottoService(lottoOutputView);
        confirmWinningService = (ConfirmWinningService) Service.generateConfirmWinningService(lottoOutputView);
        calculateProfitService = (CalculateProfitService) Service.generateCalculateProfitService(lottoOutputView);
    }

    public void programStart() {
        Integer money = getMoneyInput();

        PublishedLottos publishedLottos = getPublishedLottos(money);

        LottoBonusPair winnerNumberPair = getWinnerNumberPair();

        Long totalReward = getTotalReward(publishedLottos, winnerNumberPair);

        calculateProfit(money, totalReward);
    }

    private Integer getMoneyInput() {
        return inputService.getInputMoney();
    }

    private PublishedLottos getPublishedLottos(Integer money) {
        return publishLottoService.getPublishedLottos(money);
    }

    private LottoBonusPair getWinnerNumberPair() {
        Lotto winnerNumber = inputService.getInputWinnerNumbers();
        return inputService.getLottoBonusPair(winnerNumber);
    }

    private Long getTotalReward(PublishedLottos publishedLottos, LottoBonusPair winnerNumberPair) {
        confirmWinningService.confirmWinning(publishedLottos, winnerNumberPair);
        return confirmWinningService.getTotalReward();
    }

    private void calculateProfit(Integer money, Long totalReward) {
        calculateProfitService.calculateProfit(money, totalReward);
    }
}
