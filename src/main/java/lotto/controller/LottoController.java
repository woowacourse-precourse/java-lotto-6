package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.service.*;
import lotto.validate.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    WinningLottoFactory winningLottoFactory = new WinningLottoFactoryImpl();
    LottoGeneratorService lottoGeneratorService = new LottoGeneratorServiceImpl();

    public void start() {
        List<Lotto> lottos = getMyLottos();
        outputView.printLottos(lottos);
        Lotto lotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(lotto);
        StatisticsService statisticsService = new StatisticsServiceImpl(lottos, lotto, bonusNumber);
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
            Lotto lotto = winningLottoFactory.winningLotto(winningNumbers);
            return lotto;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return getWinningLotto();
        }
    }

    private BonusNumber getBonusNumber(Lotto lotto) {
        try {
            String inputBonusNumber = inputView.inputBonusNumber();
            BonusNumber bonusNumber = winningLottoFactory.bonusNumber(inputBonusNumber);
            LottoValidator.bonusNumberValidate(lotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return getBonusNumber(lotto);
        }
    }
}
