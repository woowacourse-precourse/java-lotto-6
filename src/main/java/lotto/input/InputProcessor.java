package lotto.input;

import java.util.Arrays;
import java.util.List;

import static lotto.GameConfig.*;

//todo :
/*
 * todo
 *  1. 도메인과 관련된 validate 로직들은 LottoGame 또는 다른 클래스로 역할 분리할 필요 있음.
 *  2. 에러 메세지 상수 뽑아내기
 *  3. 메소드, 지역변수명이 역할을 더 잘 나타내도록 수정하기.
 *  4. private methods -> static 여부 결정하기
 * */
public class InputProcessor {
    private final InputProvider inputProvider;

    public InputProcessor(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public Integer getUserPurchaseMoney() {
        String input = inputProvider.read();
        validatePurchaseMoneyInput(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = inputProvider.read();
        validateWinningNumberInput(input);
        return parseWinningNumberInputToList(input);
    }

    private void validatePurchaseMoneyInput(String input) {
        validateIsInteger(input);
        validatePurchaseMoneyUnit(input);
    }

    private void validateWinningNumberInput(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);

        validateNumberOfBalls(separatedInput);
        Arrays.stream(separatedInput)
                .forEach(this::validateIsInteger);
        Arrays.stream(separatedInput)
                .forEach((numberString) -> {
                    int number = Integer.parseInt(numberString);
                    validateRangeOfNumber(number);
                });
        validateDuplication(separatedInput);
    }

    private void validateDuplication(String[] separatedInput) {
        if (containsDuplication(separatedInput)) {
            throw new IllegalArgumentException("중복된 숫자가 존재할 수 없습니다.");
        }
    }

    private static void validateRangeOfNumber(int number) {
        if (hasInvalidRange(number)) {
            throw new IllegalArgumentException("1에서 45 사이의 정수를 입력해주십시오.");
        }
    }

    private void validateNumberOfBalls(String[] separatedInput) {
        if (!hasValidNumberOfBalls(separatedInput)) {
            throw new IllegalArgumentException("','으로 구분된 여섯 개의 숫자를 입력해주십시오.");
        }
    }

    private boolean containsDuplication(String[] separatedInput) {
        long distinctNumberCount = Arrays.stream(separatedInput)
                .distinct()
                .count();
        return distinctNumberCount != separatedInput.length;
    }

    private static boolean hasInvalidRange(int number) {
        return number < 1 || number > 45;
    }

    private boolean hasValidNumberOfBalls(String[] input) {
        return input.length == NUMBER_OF_LOTTO_NUMBERS;
    }

    private void validatePurchaseMoneyUnit(String input) {
        if (!isMultipleOfUnit(Integer.parseInt(input))) {
            throw new IllegalArgumentException("최소 단위는 ~입니다.");
        }
    }

    private boolean isMultipleOfUnit(int input) {
        return input % 1000 == 0;
    }

    private void validateIsInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주십시오");
        }
    }

    private List<Integer> parseWinningNumberInputToList(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);
        return Arrays.stream(separatedInput)
                .map(Integer::parseInt)
                .toList();
    }
}
