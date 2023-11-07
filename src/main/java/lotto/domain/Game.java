package lotto.domain;

import static common.enumtype.ErrorCode.NOT_NUMBER_STRING;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputLottoPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printLottoNumbers;

import common.exception.InvalidArgumentException;
import java.util.List;
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

    public Game(LottoNumberStrategy strategy) {
        strategy = settingStrategy(strategy);
        this.amount = createAmount();
        this.lottoes = createLottoes(strategy, amount.getLottoQuantity());
        printLottoes();
        this.winningNumbers = createNumbers();
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
        List<Integer> winningNumbers = createWinningNumbers();
        int bonusNumber = createBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private List<Integer> createWinningNumbers() {
        try {
            return createWinningNumbersFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private List<Integer> createWinningNumbersFromUser() {
        List<String> numbers = inputWinningNumbers();
        return numbers.stream()
                .map(this::parseInt)
                .toList();
    }

    private int createBonusNumber() {
        try {
            return createBonusNumberFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber();
        }
    }

    private int createBonusNumberFromUser() {
        String input = inputBonusNumber();
        return parseInt(input);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(NOT_NUMBER_STRING);
        }
    }
}
