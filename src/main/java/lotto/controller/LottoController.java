package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.winning.LottoWinningRanking;
import lotto.domain.winning.LottoWinningSet;
import lotto.exception.LottoException;
import lotto.exception.LottoStoreException;
import lotto.service.LottoProfitService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoWinningRankingService;
import lotto.service.LottoWinningSetService;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.BonusNumber;

import java.util.EnumMap;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoWinningSetService lottoWinningSetService;
    private final LottoWinningRankingService lottoWinningRankingService;
    private final LottoProfitService lottoProfitService;

    public LottoController(InputView inputView, OutputView outputView, LottoPurchaseService lottoPurchaseService, LottoWinningSetService lottoWinningSetService, LottoWinningRankingService lottoWinningRankingService, LottoProfitService lottoProfitService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoWinningSetService = lottoWinningSetService;
        this.lottoWinningRankingService = lottoWinningRankingService;
        this.lottoProfitService = lottoProfitService;
    }

    public void run() {
        Lottos userLottos = processLottoPurchaseTransaction();

        displayUserLottoPurchaseCount(userLottos);
        displayUserLottos(userLottos);

        Lotto winningLotto = processLottoWinningNumbersPickTransaction();
        BonusNumber bonusNumber = processLottoBonusNumberTransaction(winningLotto);

        EnumMap<LottoWinningRanking, Integer> winningRankingCountMap = processWinningRankingCalculationTransaction(userLottos, winningLotto, bonusNumber);
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
        return lottoWinningSetService.pickWinningNumbers(input);
    }

    private BonusNumber processLottoBonusNumberTransaction(Lotto lotto) {
        while (true) {
            try {
                outputView.requestBonusNumber();
                BonusNumber bonusNumber = getBonusNumber();
                lotto.checkAndThrowIfBonusNumberExists(bonusNumber);
                return bonusNumber;
            } catch (LottoException exception) {
                outputView.displayErrorMessage(exception.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber() throws LottoException {
        String input = inputView.inputBonusNumber();
        Validator.validateBonusNumberNumeric(input);
        return lottoWinningSetService.pickBonusNumber(input);
    }

    private EnumMap<LottoWinningRanking, Integer> processWinningRankingCalculationTransaction(Lottos userLottos, Lotto winningLotto, BonusNumber bonusNumber) {
        LottoWinningSet lottoWinningSet = new LottoWinningSet(winningLotto, bonusNumber);
        return lottoWinningRankingService.countWinningRankings(userLottos, lottoWinningSet);
    }

    private void displayWinningRankingCount(EnumMap<LottoWinningRanking, Integer> winningRankingCountMap) {
        outputView.responseWinningStatisticsHeader();
        outputView.responseWinningStatisticsBody(winningRankingCountMap);
    }
}
