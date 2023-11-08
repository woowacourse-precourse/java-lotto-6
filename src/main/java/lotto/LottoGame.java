package lotto;

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
import java.util.stream.Collectors;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import lotto.domain.strategy.RandomNumberStrategy;
import lotto.dto.LottoNumbers;

public class LottoGame {

    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = createAmount();
        Lottoes lottoes = createLottoes(lottoPurchaseAmount.getLottoCount());
        WinningNumbers winningNumbers = createNumbers();
        LottoResult lottoResult = createLottoResult(lottoes, winningNumbers);
        printResult(lottoResult, lottoResult.getYieldRate(lottoPurchaseAmount.getAmount()));
    }

    private Lottoes createLottoes(int count) {
        Lottoes lottoes = new Lottoes(new RandomNumberStrategy(), count);
        printLottoes(lottoes);
        return lottoes;
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

    private void printLottoes(Lottoes lottoes) {
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

    private LottoResult createLottoResult(Lottoes lottoes, WinningNumbers winningNumbers) {
        List<ResultType> resultTypes = calculateLottoResult(lottoes, winningNumbers);
        return new LottoResult(resultTypes);
    }

    private List<ResultType> calculateLottoResult(Lottoes lottoes, WinningNumbers winningNumbers) {
        return lottoes.getAllLotto().stream()
                .map(lotto -> winningNumbers.matchingResult(lotto.getLottoNumbers()))
                .collect(Collectors.toList());
    }

    private void printResult(LottoResult lottoResult, double yieldRate) {
        printLottoResult(lottoResult.getResult());
        printStatistics(yieldRate);
    }

    private void printStatistics(double yieldRate) {
        printWinningStatistics();
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
