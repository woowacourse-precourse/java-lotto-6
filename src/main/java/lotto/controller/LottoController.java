package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.service.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final WinningLottoFactoryService winningLottoFactoryService = WinningLottoFactoryServiceImpl.getInstance();
    private final LottoGeneratorService lottoGeneratorService = LottoGeneratorServiceImpl.getInstance();

    private LottoController() {}
    private static class  LottoControllerHelper {
        private static final LottoController LOTTO_CONTROLLER = new LottoController();
    }
    public static LottoController getInstance() {
        return LottoControllerHelper.LOTTO_CONTROLLER;
    }

    public void start() {
        List<Lotto> lottos = getMyLottos();
        outputView.printLottos(lottos);
        Lotto lotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(lotto);
        StatisticsService statisticsService = StatisticsServiceImpl.getInstance(lottos, lotto, bonusNumber);
        Result result = statisticsService.calculateResult();
        double revenueRate = statisticsService.calculateRevenueRate(lottos, result);
        outputView.result(result);
        outputView.revenueRate(revenueRate);
    }

    private List<Lotto> getMyLottos() {
        try {
            String inputPrice = inputView.inputPrice();
            List<Lotto> lottos = lottoGeneratorService.myLottos(inputPrice);
            return lottos;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return getMyLottos();
        }
    }

    private Lotto getWinningLotto() {
        try {
            String winningNumbers = inputView.inputWinningNumbers();
            Lotto lotto = winningLottoFactoryService.winningLotto(winningNumbers);
            return lotto;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return getWinningLotto();
        }
    }

    private BonusNumber getBonusNumber(Lotto lotto) {
        try {
            String inputBonusNumber = inputView.inputBonusNumber();
            BonusNumber bonusNumber = winningLottoFactoryService.bonusNumber(inputBonusNumber, lotto);
            return bonusNumber;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return getBonusNumber(lotto);
        }
    }
}