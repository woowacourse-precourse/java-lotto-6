package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.WinningNumbersValidator.*;

public class Jackpot {
    private Lotto winningNumbers;
    private int bonusNumber;

    public int countNumberOfHits(Lotto lotto) {
        return winningNumbers.countMatchingNumbers(lotto);
    }

    public boolean isBonusBallHit(Lotto lotto) {
        return lotto.isNumberInLotto(this.bonusNumber);
    }

    public Jackpot() {
        this.winningNumbers = askForWinningNumbers();
        this.bonusNumber = askForBonusNumber();
    }

    public Lotto askForWinningNumbers() {
        try {
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = readLine();
            List<Integer> winningNumbers = parseInputByComma(input);
            validateWinningNumbers(winningNumbers);
            validateUniqueNumbers(winningNumbers);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            return askForWinningNumbers();
        }
    }

    public int askForBonusNumber() {
        try {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = readLine();
            int parsedBonusNumber = validateNumberAndReturnInt(input);
            validateRange(parsedBonusNumber);
            validateBonusNumberNotInWinningNumbers(winningNumbers, parsedBonusNumber);
            return parsedBonusNumber;
        } catch (IllegalArgumentException e) {
            return askForBonusNumber();
        }
    }


    private List<Integer> parseInputByComma(String input) {
        String[] numbersArray = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numbersArray) {
            numbers.add(validateNumberAndReturnInt(numberStr));
        }
        return numbers;
    }
}
