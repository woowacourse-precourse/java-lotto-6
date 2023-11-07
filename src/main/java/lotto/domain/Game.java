package lotto.domain;

import static common.ErrorCode.NOT_NUMBER_STRING;
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
        this.lottoes = createLottoes(strategy, amount.getNumberOfLotto());
        printLottoes();
        this.winningNumbers = createWinningNumbers();
        addBonusNumber();
    }

    private void printLottoes() {
        List<LottoNumbers> lottoNumbers = lottoes.stream()
                .map(lotto -> new LottoNumbers(lotto.getLottoNumbers()))
                .toList();
        printLottoNumbers(lottoNumbers);
    }

    private LottoNumberStrategy settingStrategy(LottoNumberStrategy strategy) {
        if(strategy == null) {
            return new RandomNumberStrategy();
        }
        return strategy;
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

    private void addBonusNumber() {
        try {
            winningNumbers.addBonus(createBonusNumber());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private WinningNumber createBonusNumber() {
        try {
            return createBonusNumberFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber();
        }
    }

    private WinningNumber createBonusNumberFromUser() {
        String input = inputBonusNumber();
        int bonusNumber = parseInt(input);
        return new WinningNumber(bonusNumber);
    }

    private WinningNumbers createWinningNumbers() {
        try {
            return createWinningNumbersFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private WinningNumbers createWinningNumbersFromUser() {
        List<String> numbers = inputWinningNumbers();
        List<Integer> winningNumbers = numbers.stream()
                .map(this::parseInt)
                .toList();
        return new WinningNumbers(winningNumbers);
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

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(NOT_NUMBER_STRING);
        }
    }
}
