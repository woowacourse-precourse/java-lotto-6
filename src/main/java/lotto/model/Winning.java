package lotto.model;

import java.util.List;

public class Winning {

    private static String WINNING_NUMBERS_MUST_BE_6 = "당첨 번호는 6개를 입력해 주세요.";
    private static String WINNING_NUMBER_RANGE_IS_1_TO_45 = "1부터 45까지의 당첨번호를 입력해 주세요.";
    private static String WINNING_NUMBERS_MUST_BE_DISTINCT = "당첨 번호는 중복이 아니여야 합니다.";
    private static int BONUS_NUMBER_INDEX = 6;

    private List<Integer> numbers;

    public Winning(List<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        validateWinningNumbersSize(numbers);
        validateWinningNumbersDistinct(numbers);
        numbers.forEach(this::validateNumberRange);
    }

    private void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_MUST_BE_6);
        }
    }

    private void validateWinningNumbersDistinct(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_MUST_BE_DISTINCT);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 0 || 45 < number) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_IS_1_TO_45);
        }
    }

    public void addBonusNumber(int number) {
        validateNumberRange(number);
        numbers.add(number);
        validateWinningNumbersDistinct(numbers);
    }

}
