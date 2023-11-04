package lotto.controller;

import lotto.domain.generator.LottoManualGenerator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.profit.LottoProfitCalculator;
import lotto.domain.store.LottoStore;
import lotto.domain.winning.WinningRanking;
import lotto.domain.winning.WinningRankingCalculator;
import lotto.domain.winning.WinningNumbers;
import lotto.dto.LottoDto;
import lotto.exception.InvalidNumberFormatException;
import lotto.exception.LottoException;
import lotto.exception.MarketException;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.BonusNumber;

import java.util.EnumMap;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore lottoStore;
    private final WinningRankingCalculator winningRankingCalculator;
    private final LottoProfitCalculator lottoProfitCalculator;

    public LottoController(InputView inputView, OutputView outputView, LottoStore lottoStore, WinningRankingCalculator winningRankingCalculator, LottoProfitCalculator lottoProfitCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
        this.winningRankingCalculator = winningRankingCalculator;
        this.lottoProfitCalculator = lottoProfitCalculator;
    }

    public void run() {
        Lottos userLottos = processLottoPurchaseTransaction();

        displayUserLottoPurchaseCount(userLottos);
        displayUserLottos(userLottos);

        Lotto winningLotto = processLottoWinningNumbersPickTransaction();
        BonusNumber bonusNumber = processLottoBonusNumberTransaction(winningLotto);

        EnumMap<WinningRanking, Integer> winningRankingCountMap = processWinningRankingCalculationTransaction(userLottos, winningLotto, bonusNumber);
        displayWinningRankingCount(winningRankingCountMap);

        double profit = processUserProfitCalculationTransaction(userLottos, winningRankingCountMap);
        displayProfit(profit);
    }

    private void displayProfit(double profit) {
        outputView.responseTotalReturn(profit);
    }

    private double processUserProfitCalculationTransaction(Lottos userLottos, EnumMap<WinningRanking, Integer> winningRankingCountMap) {
        return lottoProfitCalculator.calculateProfit(winningRankingCountMap, userLottos.getSize());
    }

    private Lottos processLottoPurchaseTransaction() {
        while (true) {
            try {
                outputView.requestPurchaseAmount();
                int userPurchaseAmount = getUserPurchaseAmount();
                return lottoStore.purchaseAutoLottos(userPurchaseAmount);
            } catch (InvalidNumberFormatException | LottoException | MarketException exception) {
                outputView.displayErrorMessage(exception.getMessage());
            }
        }
    }

    private int getUserPurchaseAmount() {
        String userPurchaseAmount = inputView.inputPurchaseAmount();
        validateNumeric(userPurchaseAmount);
        return Integer.parseInt(userPurchaseAmount);
    }

    private void displayUserLottoPurchaseCount(Lottos lottos) {
        outputView.responsePurchaseCount(lottos.getSize());
    }

    private void displayUserLottos(Lottos lottos) {
        List<LottoDto> lottosDto = lottos.lottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
        outputView.responseUserNumbersSet(lottosDto);
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
        validateLottoNumbers(input);
        List<String> splitLottoNumbers = List.of(input.split(","));

        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator();
        return lottoManualGenerator.generate(splitLottoNumbers);
    }

    private BonusNumber processLottoBonusNumberTransaction(Lotto lotto) {
        while (true) {
            try {
                outputView.requestBonusNumber();
                BonusNumber bonusNumber = getBonusNumber();
                lotto.checkAndThrowIfBonusNumberExists(bonusNumber);
                return bonusNumber;
            } catch (InvalidNumberFormatException | LottoException exception) {
                outputView.displayErrorMessage(exception.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber() throws InvalidNumberFormatException, LottoException {
        String input = inputView.inputBonusNumber();
        validateNumeric(input);
        return new BonusNumber(Integer.parseInt(input));
    }

    private EnumMap<WinningRanking, Integer> processWinningRankingCalculationTransaction(Lottos userLottos, Lotto winningLotto, BonusNumber bonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        return winningRankingCalculator.countWinningRankings(userLottos, winningNumbers);
    }

    private void displayWinningRankingCount(EnumMap<WinningRanking, Integer> winningRankingCountMap) {
        outputView.responseWinningStatisticsHeader();
        outputView.responseWinningStatisticsBody(winningRankingCountMap);
    }
    
    private void validateNumeric(String input) throws InvalidNumberFormatException {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(InvalidNumberFormatException.ErrorMessage.NUMBER.getMessage());
        }
    }

    private static void validateLottoNumbers(String lottoNumbers) throws LottoException {
        String regex = "^\\d{1,2}(,\\d{1,2}){5}$";
        if (!lottoNumbers.matches(regex)) {
            throw new LottoException(LottoException.ErrorMessage.INVALID_NUMBERS.getMessage());
        }
    }
}
