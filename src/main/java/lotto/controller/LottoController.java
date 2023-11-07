package lotto.controller;

import lotto.domain.*;
import lotto.exception.InvalidInputException;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoResultService lottoResultService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService, LottoResultService lottoResultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.lottoResultService = lottoResultService;
    }

    public void run() {
        Long lottoCount = purchaseLotto();

        PurchasedLotto purchasedLotto = purchaseLottoByLottoCount(lottoCount);
        WinningLotto winningLotto = winningInput();

        List<LottoResult> lottoResults = lottoResultService.countMatchingNumbers(purchasedLotto, winningLotto);
        Map<LottoReward, Integer> reward = lottoResultService.confirmRewardLottos(lottoResults);
        Double earnRate = lottoResultService.countEarnRate(reward, lottoCount);

        outputView.resultLotto(reward, earnRate);
    }

    private WinningLotto winningInput() {
        outputView.inputWinningNumbersMessage();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        outputView.inputBonusNumberMessage();
        Integer bonusNumber = inputView.inputBonusNumber();

        return new WinningLotto(winningNumbers, new BonusNumber(bonusNumber));
    }


    private PurchasedLotto purchaseLottoByLottoCount(Long lottoCount) {
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = lottoService.createRandomNumbers();
            purchasedLotto.addLotto(new Lotto(randomNumbers));
        }

        outputView.purchaseLottoNumbers(purchasedLotto);
        return purchasedLotto;
    }

    private Long purchaseLotto() {
        while (true) {
            outputView.purchaseLottoMessage();
            Long userMoney = inputView.purchaseLotto();

            try {
                Long lottoCount = lottoService.purchaseLottoWithValidPrice(userMoney);
                outputView.purchaseLottoCountMessage(lottoCount);

                return lottoCount;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}