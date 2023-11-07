package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumbers {

    private static final String WINNING_GENERAL_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String WINNING_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 잘못된 번호를 입력했습니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 번호가 있습니다.";
    private final List<Integer> generalNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> generalNumbers, int bonusNumber) {
        validate(generalNumbers, bonusNumber);
        this.generalNumbers = generalNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers createWinningNumbers() {
        try {
            return inputWinningNumbers();
        } catch (IllegalArgumentException ex) {
            System.out.println(INPUT_ERROR_MESSAGE);
            return createWinningNumbers();
        }
    }

    private static WinningNumbers inputWinningNumbers() {
        List<Integer> generalNumbers = inputGeneralNumbers();
        int bonusNumber = inputBonusNumber();
        return new WinningNumbers(generalNumbers, bonusNumber);
    }

    private static List<Integer> inputGeneralNumbers() {
        try {
            OutputView.printMessage(WINNING_GENERAL_NUMBER_INPUT_MESSAGE);
            String input = InputView.readMessage();
            OutputView.printMessage();
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private static int inputBonusNumber() {
        try {
            OutputView.printMessage(WINNING_BONUS_NUMBER_INPUT_MESSAGE);
            String input = InputView.readMessage();
            OutputView.printMessage();
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void validate(List<Integer> generalNumbers, int bonusNumber) {
        validateSize(generalNumbers);
        generalNumbers.forEach(this::validateRange);
        validateRange(bonusNumber);
        validateDuplicate(generalNumbers, bonusNumber);
    }

    private void validateSize(List<Integer> generalNumbers) {
        if (generalNumbers.size() != Lotto.LOTTO_NUMBER) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void validateRange(int number) {
        if (number < Lotto.LOTTO_RANGE_BEGIN || number > Lotto.LOTTO_RANGE_END) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> generalNumbers, int bonusNumber) {
        HashSet<Integer> duplicateCheckSet = new HashSet<>();
        generalNumbers.forEach(number -> checkDuplicate(duplicateCheckSet, number));
        checkDuplicate(duplicateCheckSet, bonusNumber);
    }

    private void checkDuplicate(HashSet<Integer> duplicateCheckSet, Integer number) {
        if (duplicateCheckSet.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
        duplicateCheckSet.add(number);
    }

}
