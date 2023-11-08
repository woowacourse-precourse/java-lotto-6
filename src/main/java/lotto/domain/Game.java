package lotto.domain;

import static common.enumtype.ErrorCode.NOT_NUMBER_STRING;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputLottoPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printLottoNumbers;
import static lotto.view.OutputView.printLottoResult;
import static lotto.view.OutputView.printTotalYieldRate;

import common.enumtype.ResultType;
import common.exception.InvalidArgumentException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.strategy.LottoNumberStrategy;
import lotto.domain.strategy.RandomNumberStrategy;
import lotto.dto.LottoNumbers;

public class Game {

    public static final int START_INCLUSIVE = 0;
    private final LottoPurchaseAmount amount;
    private final List<Lotto> lottoes;
    private final WinningNumbers winningNumbers;
    private final LottoResult lottoResult;

    public Game(LottoNumberStrategy strategy) {
        strategy = settingStrategy(strategy);
        this.amount = createAmount();
        this.lottoes = createLottoes(strategy, amount.getLottoQuantity());
        printLottoes();
        this.winningNumbers = createNumbers();
        this.lottoResult = createLottoResult();
        printResult();
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

    private List<Lotto> createLottoes(LottoNumberStrategy strategy, int number) {
        return IntStream.range(START_INCLUSIVE, number)
                .mapToObj(i -> createLotto(strategy))
                .collect(Collectors.toList());
    }

    private Lotto createLotto(LottoNumberStrategy strategy) {
        try {
            List<Integer> numbers = strategy.createNumber();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLotto(strategy);
        }
    }

    private void printLottoes() {
        List<LottoNumbers> lottoNumbers = lottoes.stream()
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
        return lottoes.stream()
                .map(lotto -> winningNumbers.matchingResult(lotto.getLottoNumbers()))
                .collect(Collectors.toList());
    }

    private void printResult() {
        Map<ResultType, Integer> result = lottoResult.getResult();
        printLottoResult(result);
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
