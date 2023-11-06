package lotto;

import lotto.domain.RandomNumberGenerator;
import lotto.output.NumberGeneratorOutput;
import lotto.output.PurchaseResultHandler;

import java.util.Set;

import static lotto.input.WinningNumbers.getWinningNumbers;

public class Application {
    public static void main(String[] args) {
        int numberOfLotto = PurchaseResultHandler.purchaseRequest();

        RandomNumberGenerator numbers = new RandomNumberGenerator();
        NumberGeneratorOutput numbersOutput = new NumberGeneratorOutput();
        numbersOutput.printLotteryNumbers(numbers, numberOfLotto);

        Set<Integer> winningNumbers = getWinningNumbers();
        System.out.println(winningNumbers);

    }
}

