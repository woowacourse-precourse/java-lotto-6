package lotto;

import lotto.domain.RandomNumberGenerator;
import lotto.input.BonusNumber;
import lotto.output.RandomNumberGeneratorOutput;
import lotto.output.PurchaseResultHandler;

import java.util.Set;

import static lotto.input.WinningNumbers.getWinningNumbers;

public class Application {
    public static void main(String[] args) {
        int numberOfLotto = PurchaseResultHandler.purchaseRequest();

        RandomNumberGenerator numbers = new RandomNumberGenerator();
        RandomNumberGeneratorOutput numbersOutput = new RandomNumberGeneratorOutput();
        numbersOutput.printLotteryNumbers(numbers, numberOfLotto);

        Set<Integer> winningNumbers = getWinningNumbers();

        int bonusNum = BonusNumber.bonusInput(winningNumbers);

    }
}

