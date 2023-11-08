package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.common.Announcement;
import lotto.common.ConstraintString;
import lotto.common.ErrorMessage;
import lotto.common.LottoNumberValidator;

public class LottoDrawMachine {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    LottoDrawMachine() {
    }

    public void drawNumberManual() {
        this.winningNumbers = getWinningNumbersFromInput();
        this.bonusNumber = getBonusNumberFromInput();
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private List<Integer> getWinningNumbersFromInput() {
        Announcement.INPUT_WINNING_NUMBERS.speak();
        while (true) {
            try {
                List<Integer> winningNumbers = parseInputToNumbers(
                    Console.readLine(),
                    ConstraintString.SPLIT_REGEX.getValue()
                );
                LottoNumberValidator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private int getBonusNumberFromInput() {
        Announcement.INPUT_BONUS_NUMBER.speak();
        while (true) {
            try {
                int bonusNumber = parseInputToNumber(Console.readLine());
                LottoNumberValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private List<Integer> parseInputToNumbers(String input, String regex) {
        String[] inputStrings = input.split(regex);
        LottoNumberValidator.validateNumeric(inputStrings);
        return Arrays.stream(inputStrings)
            .map(Integer::parseInt)
            .toList();
    }

    private int parseInputToNumber(String input) {
        LottoNumberValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }

}
