package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.profit.LottoProfitCalculator;
import lotto.domain.winning.LottoWinningSetPicker;
import lotto.domain.winning.LottoWinningRanking;
import lotto.domain.winning.LottoWinningRankingCalculator;
import lotto.domain.winning.LottoWinningSet;
import lotto.exception.LottoException;
import lotto.exception.LottoStoreException;
import lotto.service.LottoStoreService;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.BonusNumber;

import java.util.EnumMap;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStoreService lottoStoreService;
    private final LottoWinningSetPicker lottoWinningSetPicker;
    private final LottoWinningRankingCalculator lottoWinningRankingCalculator;
    private final LottoProfitCalculator lottoProfitCalculator;

    public LottoController(InputView inputView, OutputView outputView, LottoStoreService lottoStoreService, LottoWinningSetPicker lottoWinningSetPicker, LottoWinningRankingCalculator lottoWinningRankingCalculator, LottoProfitCalculator lottoProfitCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStoreService = lottoStoreService;
        this.lottoWinningSetPicker = lottoWinningSetPicker;
        this.lottoWinningRankingCalculator = lottoWinningRankingCalculator;
        this.lottoProfitCalculator = lottoProfitCalculator;
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
        return lottoProfitCalculator.calculateProfit(winningRankingCountMap, userLottos.getSize());
    }

    private Lottos processLottoPurchaseTransaction() {
        while (true) {
            try {
                outputView.requestPurchaseAmount();
                int userPurchaseAmount = getUserPurchaseAmount();
                return lottoStoreService.purchaseAutoLottos(userPurchaseAmount);
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
        return lottoWinningSetPicker.pickWinningNumbers(input);
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
        return lottoWinningSetPicker.pickBonusNumber(input);
    }

    private EnumMap<LottoWinningRanking, Integer> processWinningRankingCalculationTransaction(Lottos userLottos, Lotto winningLotto, BonusNumber bonusNumber) {
        LottoWinningSet lottoWinningSet = new LottoWinningSet(winningLotto, bonusNumber);
        return lottoWinningRankingCalculator.countWinningRankings(userLottos, lottoWinningSet);
    }

    private void displayWinningRankingCount(EnumMap<LottoWinningRanking, Integer> winningRankingCountMap) {
        outputView.responseWinningStatisticsHeader();
        outputView.responseWinningStatisticsBody(winningRankingCountMap);
    }
}
