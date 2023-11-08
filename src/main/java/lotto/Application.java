package lotto;

import lotto.domain.LottoResultAnalyzer;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.RateOfReturn;
import lotto.input.BonusNumber;
import lotto.output.LottoResultOutput;
import lotto.output.RandomNumberGeneratorOutput;
import lotto.output.PurchaseResultHandler;

import java.util.List;
import java.util.Set;

import static lotto.domain.RateOfReturn.calculateRateOfReturn;
import static lotto.domain.RateOfReturn.rateOfReturnOutput;
import static lotto.input.WinningNumbers.getWinningNumbers;

public class Application {
    public static void main(String[] args) {
        int numberOfLotto = PurchaseResultHandler.requestPurchase();
        RandomNumberGenerator randomNumbers = new RandomNumberGenerator();
        RandomNumberGeneratorOutput numbersOutput = new RandomNumberGeneratorOutput();

        printLotteryNumbers(numberOfLotto, randomNumbers, numbersOutput);

        Set<Integer> winningNumbers = getWinningNumbers();
        int bonusNum = BonusNumber.bonusInput(winningNumbers);

        List<Integer> winnings = calculateWinnings(randomNumbers, winningNumbers, bonusNum);
        printWinnings(winnings);

        double result = calculateAndOutputRateOfReturn(numberOfLotto, winnings);
    }

    private static void printLotteryNumbers(int numberOfLotto, RandomNumberGenerator randomNumbers, RandomNumberGeneratorOutput numbersOutput) {
        numbersOutput.printLotteryNumbers(randomNumbers, numberOfLotto);
    }

    private static List<Integer> calculateWinnings(RandomNumberGenerator randomNumbers, Set<Integer> winningNumbers, int bonusNum) {
        return LottoResultAnalyzer.calculateWinnings(randomNumbers.getLotteries(), winningNumbers, bonusNum);
    }

    private static void printWinnings(List<Integer> winnings) {
        LottoResultOutput.printResult(winnings);
    }

    private static double calculateAndOutputRateOfReturn(int numberOfLotto, List<Integer> winnings) {
        double result = calculateRateOfReturn(numberOfLotto, winnings);
        rateOfReturnOutput(result);
        return result;
    }
}
