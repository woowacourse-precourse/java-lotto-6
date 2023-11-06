package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottoWinningRanking;
import lotto.vo.LottoWinningNumbers;
import lotto.exception.LottoException;
import lotto.exception.LottoStoreException;
import lotto.service.LottoProfitService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoWinningRankingService;
import lotto.service.LottoWinningNumbersPickService;
import lotto.validation.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.LottoWinningBonusNumber;

import java.util.EnumMap;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoWinningNumbersPickService lottoWinningNumbersPickService;
    private final LottoWinningRankingService lottoWinningRankingService;
    private final LottoProfitService lottoProfitService;

    public LottoController(InputView inputView, OutputView outputView, LottoPurchaseService lottoPurchaseService, LottoWinningNumbersPickService lottoWinningNumbersPickService, LottoWinningRankingService lottoWinningRankingService, LottoProfitService lottoProfitService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoWinningNumbersPickService = lottoWinningNumbersPickService;
        this.lottoWinningRankingService = lottoWinningRankingService;
        this.lottoProfitService = lottoProfitService;
    }

    public void run() {
        Lottos userLottos = processLottoPurchaseTransaction();

        displayUserLottoPurchaseCount(userLottos);
        displayUserLottos(userLottos);

        Lotto winningLotto = processLottoWinningNumbersPickTransaction();
        LottoWinningBonusNumber lottoWinningBonusNumber = processLottoWinningBonusNumberTransaction(winningLotto);

        EnumMap<LottoWinningRanking, Integer> winningRankingCountMap = processWinningRankingCalculationTransaction(userLottos, winningLotto, lottoWinningBonusNumber);
        displayWinningRankingCount(winningRankingCountMap);

        double profit = processUserProfitCalculationTransaction(userLottos, winningRankingCountMap);
        displayProfit(profit);
    }

    private void displayProfit(double profit) {
        outputView.responseProfit(profit);
    }

    private double processUserProfitCalculationTransaction(Lottos userLottos, EnumMap<LottoWinningRanking, Integer> winningRankingCountMap) {
        return lottoProfitService.calculateProfit(winningRankingCountMap, userLottos.getSize());
    }

    private Lottos processLottoPurchaseTransaction() {
        while (true) {
            try {
                outputView.requestPurchaseAmount();
                int userPurchaseAmount = getUserPurchaseAmount();
                return lottoPurchaseService.purchaseAutoLottos(userPurchaseAmount);
            } catch (LottoException | LottoStoreException exception) {
                outputView.displayErrorMessage(exception.getMessage());
            }
        }
    }

    private int getUserPurchaseAmount() {
        String userPurchaseAmount = inputView.inputPurchaseAmount();
        Validator.validateLottoAmountNumeric(userPurchaseAmount);
        return Integer.parseInt(userPurchaseAmount);
    }

    private void displayUserLottoPurchaseCount(Lottos lottos) {
        outputView.responsePurchaseCount(lottos.getSize());
    }

    private void displayUserLottos(Lottos lottos) {
        outputView.responseUserNumbersSet(lottos);
    }

    private Lotto processLottoWinningNumbersPickTransaction() {
        while (true) {
            try {
                outputView.requestWinningNumbers();
                return getLottoWinningNumbers();
            } catch (LottoException exception) {
                outputView.displayErrorMessage(exception.getMessage());
            }
        }
    }

    private Lotto getLottoWinningNumbers() throws LottoException {
        String input = inputView.inputWinningNumbers();
        Validator.validatedWinningNumbersFormat(input);
        return lottoWinningNumbersPickService.pickWinningNumbers(input);
    }

    private LottoWinningBonusNumber processLottoWinningBonusNumberTransaction(Lotto lotto) {
        while (true) {
            try {
                outputView.requestBonusNumber();
                LottoWinningBonusNumber lottoWinningBonusNumber = getBonusNumber();
                lotto.validateAndThrowIfBonusNumberExists(lottoWinningBonusNumber);
                return lottoWinningBonusNumber;
            } catch (LottoException exception) {
                outputView.displayErrorMessage(exception.getMessage());
            }
        }
    }

    private LottoWinningBonusNumber getBonusNumber() throws LottoException {
        String input = inputView.inputBonusNumber();
        Validator.validateBonusNumberNumeric(input);
        return lottoWinningNumbersPickService.pickBonusNumber(input);
    }

    private EnumMap<LottoWinningRanking, Integer> processWinningRankingCalculationTransaction(Lottos userLottos, Lotto winningLotto, LottoWinningBonusNumber lottoWinningBonusNumber) {
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningLotto, lottoWinningBonusNumber);
        return lottoWinningRankingService.countWinningRankings(userLottos, lottoWinningNumbers);
    }

    private void displayWinningRankingCount(EnumMap<LottoWinningRanking, Integer> winningRankingCountMap) {
        outputView.responseWinningStatisticsHeader();
        outputView.responseWinningStatisticsBody(winningRankingCountMap);
    }
}
