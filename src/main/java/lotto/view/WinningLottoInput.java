package lotto.view;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import lotto.exception.WinningNumException;

public class WinningLottoInput {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    private static final String WINNIG_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static List<Integer> winnigLottoInput() {
        System.out.println(WINNIG_LOTTO_MESSAGE);
        String numbers = UserInput.userInput();
        List<String> nums = separateNumbers(numbers);
        List<Integer> wins = validateWinning(nums);
        wins = sorted(wins);
        return wins;
    }

    public static List<String> separateNumbers(String numbers) {
        List<String> nums = Arrays.asList(numbers.split(","));
        return nums;
    }

    public static List<Integer> validateWinning(List<String> nums) {
        try {
            validateSize(nums);
            eachNumber(nums);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + System.lineSeparator());
            return winnigLottoInput();
        }
        return toIntList(nums);
    }

    public static void validateSize(List<String> nums) {
        if (nums.size() != SIZE) {
            WinningNumException.winningSizeException();
        }
    }

    public static void eachNumber(List<String> nums) {
        for (String win : nums) {
            int num = validateInt(win);
            validateRange(num);
        }
    }

    public static int validateInt(String win) {
        try {
            Integer.parseInt(win);
        } catch (NumberFormatException e) {
            WinningNumException.winningIntException();
        }
        return Integer.parseInt(win);
    }

    public static void validateRange(int num) {
        if (num < MIN || num > MAX) {
            WinningNumException.winningRangeException();
        }
    }

    public static List<Integer> toIntList(List<String> nums) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : nums) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    public static List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
            .sorted()
            .collect(Collectors.toList());
    }

}
