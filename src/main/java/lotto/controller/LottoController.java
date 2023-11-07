package lotto.controller;

import lotto.domain.*;
import lotto.exception.DuplicateInputException;
import lotto.exception.InvalidInputException;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoResultService lottoResultService;

    public LottoController(InputView inputView, OutputView outputView, LottoPurchaseService lottoPurchaseService, LottoResultService lottoResultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoPurchaseService = lottoPurchaseService;
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
        while (true) {
            try {
                outputView.inputWinningNumbersMessage();
                List<Integer> winningNumbers = inputView.inputWinningNumbers();

                outputView.inputBonusNumberMessage();
                BonusNumber bonusNumber = inputView.inputBonusNumber();

                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (DuplicateInputException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }


    private PurchasedLotto purchaseLottoByLottoCount(Long lottoCount) {
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = lottoPurchaseService.generateRandomLottoNumbers();
            purchasedLotto.addLotto(new Lotto(randomNumbers));
        }

        outputView.purchaseLottoNumbers(purchasedLotto);
        return purchasedLotto;
    }

    private Long purchaseLotto() {
        while (true) {
            outputView.purchaseLottoMessage();

            try {
                Long userMoney = inputView.purchaseLotto();
                Long lottoCount = lottoPurchaseService.calculateNumberOfLotto(userMoney);
                outputView.purchaseLottoCountMessage(lottoCount);

                return lottoCount;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}