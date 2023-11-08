package lotto.domain;

import static common.enumtype.ErrorCode.NOT_NUMBER_STRING;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputLottoPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printLottoNumbers;
import static lotto.view.OutputView.printLottoResult;
import static lotto.view.OutputView.printTotalYieldRate;
import static lotto.view.OutputView.printWinningStatistics;

import common.enumtype.ResultType;
import common.exception.InvalidArgumentException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.strategy.LottoNumberStrategy;
import lotto.domain.strategy.RandomNumberStrategy;
import lotto.dto.LottoNumbers;

public class Game {

    private final LottoPurchaseAmount amount;
    private final Lottoes lottoes;
    private final WinningNumbers winningNumbers;
    private final LottoResult lottoResult;

    public Game(LottoNumberStrategy strategy) {
        strategy = settingStrategy(strategy);
        this.amount = createAmount();
        this.lottoes = new Lottoes(strategy, amount.getLottoQuantity());
        printLottoes();
        this.winningNumbers = createNumbers();
        this.lottoResult = createLottoResult();
        printStatistics();
    }

    private LottoNumberStrategy settingStrategy(LottoNumberStrategy strategy) {
        if(strategy == null) {
            return new RandomNumberStrategy();
        }
        return strategy;
    }

    private LottoPurchaseAmount createAmount() {
        try {
            return createAmountFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createAmount();
        }
    }

    private LottoPurchaseAmount createAmountFromUser() {
        String input = inputLottoPurchaseAmount();
        int amount = parseInt(input);
        return new LottoPurchaseAmount(amount);
    }

    private void printLottoes() {
        List<LottoNumbers> lottoNumbers = lottoes.getAllLotto().stream()
                .map(lotto -> new LottoNumbers(lotto.getLottoNumbers()))
                .toList();
        printLottoNumbers(lottoNumbers);
    }

    private WinningNumbers createNumbers() {
        try {
            List<WinningNumber> winningNumbers = createWinningNumbers();
            WinningNumber bonusNumber = createBonusNumber();
            return new WinningNumbers(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createNumbers();
        }
    }

    private List<WinningNumber> createWinningNumbers() {
        try {
            List<Integer> winningNumbers = createWinningNumbersFromUser();
            return convertToWiningNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private List<WinningNumber> convertToWiningNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .map(WinningNumber::new)
                .collect(Collectors.toList());
    }

    private List<Integer> createWinningNumbersFromUser() {
        List<String> numbers = inputWinningNumbers();
        return numbers.stream()
                .map(this::parseInt)
                .toList();
    }

    private WinningNumber createBonusNumber() {
        try {
            int bonusNumber = createBonusNumberFromUser();
            return new WinningNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber();
        }
    }

    private int createBonusNumberFromUser() {
        String input = inputBonusNumber();
        return parseInt(input);
    }

    private LottoResult createLottoResult() {
        List<ResultType> resultTypes = calculateLottoResult();
        return new LottoResult(resultTypes);
    }

    private List<ResultType> calculateLottoResult() {
        return lottoes.getAllLotto().stream()
                .map(lotto -> winningNumbers.matchingResult(lotto.getLottoNumbers()))
                .collect(Collectors.toList());
    }

    private void printStatistics() {
        printWinningStatistics();
        printResult();
        printYieldRate();
    }

    private void printResult() {
        Map<ResultType, Integer> result = lottoResult.getResult();
        printLottoResult(result);
    }

    private void printYieldRate() {
        int lottoPurchaseAmount = amount.getLottoPurchaseAmount();
        double yieldRate = lottoResult.getYieldRate(lottoPurchaseAmount);
        printTotalYieldRate(yieldRate);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(NOT_NUMBER_STRING);
        }
    }
}
