package lotto.input;

import java.util.Arrays;
import java.util.List;

import static lotto.GameConfig.*;

public class InputProcessor {
    private final InputProvider inputProvider;

    public InputProcessor(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public Integer getUserPurchaseMoney() {
        String input = inputProvider.read();
        validatePurchaseMoneyInput(input);
        return Integer.valueOf(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = inputProvider.read();
        validateWinningNumberInput(input);
        return parseWinningNumberInputToList(input);
    }

    private List<Integer> parseWinningNumberInputToList(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);
        return Arrays.stream(separatedInput)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateWinningNumberInput(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);

        if (!hasValidNumberOfBalls(separatedInput)) {
            throw new IllegalArgumentException("\',\'으로 구분된 여섯 개의 숫자를 입력해주십시오.");
        }
        if (!hasValidRangeOfNumber(separatedInput)) {
            throw new IllegalArgumentException("1에서 45 사이의 정수를 입력해주십시오.");
        }
        if (!containsDuplication(separatedInput)) {
            throw new IllegalArgumentException("중복된 숫자가 존재할 수 없습니다.");
        }
    }

    private boolean containsDuplication(String[] separatedInput) {
        long distinctNumberCount = Arrays.stream(separatedInput)
                .distinct()
                .count();
        return distinctNumberCount == separatedInput.length;
    }

    // todo: 가독성을 높이기 위해 로직 분리 or 수정 필요
    private boolean hasValidRangeOfNumber(String[] seperatedInput) {
        long numberOfInteger = Arrays.stream(seperatedInput)
                .filter(InputProcessor::isNotInteger)
                .count();
        if (seperatedInput.length != numberOfInteger) {
            return false;
        }
        return Arrays.stream(seperatedInput).anyMatch((t) -> {
            int number = Integer.parseInt(t);
            return number < 1 || number > 45;
        });
    }

    private boolean hasValidNumberOfBalls(String[] input) {
        return input.length == NUMBER_OF_LOTTO_NUMBERS;
    }

    private void validatePurchaseMoneyInput(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException("정수를 입력해주십시오.");
        }
        if (!isMultipleOfUnit(Integer.parseInt(input))) {
            throw new IllegalArgumentException("최소 단위는 ~입니다.");
        }
    }

    private boolean isMultipleOfUnit(int input) {
        return input % 1000 == 0;
    }

    private static boolean isNotInteger(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
