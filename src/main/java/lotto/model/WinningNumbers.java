package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private static final String WINNING_NUMBER_REGEX = "^[0-9,]*$";
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String EMPTY_MESSAGE = "[ERROR] 번호가 입력되지 않았습니다.";
    private static final String INVALID_WINNING_NUMBER_MESSAGE = "[ERROR] 로또 당첨 번호는 숫자 또는 쉼표(,)로만 구성되어야 합니다.";
    private static final String INVALID_SIZE_MESSAGE = "[ERROR] 로또 당첨 번호는 6개의 숫자여야 합니다.";
    private static final String INVALID_WINNING_NUMBER_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 다른 번호여야 합니다.";
    private static final String INVALID_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    private static final String INVALID_BONUS_NUMBER_SIZE_MESSAGE = "[ERROR] 보너스 번호는 1개의 숫자여야 합니다.";
    private static final String INVALID_BONUS_NUMBER_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 다른 번호여야 합니다.";

    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(String inputNumbers) {
        this.numbers = validateNumbers(inputNumbers);
    }

    public void addBonusNumber(String bonusNumber) {
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    private List<Integer> validateNumbers(String inputNumbers) {
        if (inputNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }

        if (!inputNumbers.matches(WINNING_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_MESSAGE);
        }

        List<Integer> numbers = new ArrayList<>();

        for (String number : inputNumbers.split(",")) {
            numbers.add(Integer.parseInt(number));
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }

        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE_MESSAGE);
        }

        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE);
        }

        return numbers;
    }

    private int validateBonusNumber(String inputBonusNumber) {
        if (inputBonusNumber.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }

        if (!inputBonusNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_MESSAGE);
        }

        if (inputBonusNumber.length() > 2) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_SIZE_MESSAGE);
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE_MESSAGE);
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MESSAGE);
        }

        return bonusNumber;
    }
}
