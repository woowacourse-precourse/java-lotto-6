package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.Announcement;
import lotto.common.Constraint;
import lotto.common.ErrorMessage;

public class LottoDrawMachine {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    LottoDrawMachine() {
//        this.winningNumbers = new ArrayList<>();
    }

    public void drawNumberManual() {
        // winningNumber 입력 받기
        this.winningNumbers = getWinningNumbersFromInput();
        System.out.println(this.winningNumbers);
        // bonusNumber 입력받기
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
                String input = Console.readLine();
                String[] inputWinningNumbers = input.split(",");
                validateNumericInputNumbers(inputWinningNumbers);
                validateOverSize(inputWinningNumbers);
                return Arrays.stream(inputWinningNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private void validateNumericInputNumbers(String[] inputNumbers) {
        try {
            for (String string : inputNumbers) {
                Integer.parseInt(string);
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_NUMERIC.getMessage());
        }
    }

    private void validateOverSize(String[] inputNumbers) {
        if (inputNumbers.length != Constraint.LOTTO_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OVER_SIZE.getMessage());
        }
    }
}
