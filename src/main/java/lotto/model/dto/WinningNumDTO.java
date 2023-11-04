package lotto.model.dto;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.DUPLICATED_NUMBER;
import static lotto.constants.ExceptionMessages.DUPLICATED_WITH_WINNING_NUM;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;
import static lotto.constants.ExceptionMessages.INVALID_RANGE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constants.ExceptionMessages;

public class WinningNumDTO {
    private static final String SEPARATOR = ",";
    private static final int TOTAL_NUM = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private List<Integer> winningNums;
    private int bonus;
    private WinningNumDTO(List<Integer> winningNums, int bonus) {
        this.winningNums = winningNums;
        this.bonus = bonus;
    }

    public static WinningNumDTO of(String winText, String bonusText) {
        List<Integer> winningNums = split(winText);
        int bonusNum = validateBonus(bonusText);
        checkOverlappingWithWinningNums(winningNums, bonusNum);
        return new WinningNumDTO(winningNums, bonusNum);
    }

    public static int validateBonus(String bonus) {
        checkNull(bonus);
        int bonusNum = toInteger(bonus);
        checkRange(bonusNum);
        return bonusNum;
    }

    private static void checkOverlappingWithWinningNums(List<Integer> winningNums, int bonusNum) {
        if(winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException(CATCH_ERROR + DUPLICATED_WITH_WINNING_NUM);
        }
    }

    public static void validateWinningNums(String winNums) {
        checkNull(winNums);
        List<Integer> numbers = split(winNums);
        checkTotalNum(numbers);
        numbers.forEach(num -> checkRange(num));
    }

    private static void checkRange(int num) {
        if(num < MIN_NUM || num > MAX_NUM) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_RANGE);
        }
    }

    private static void checkTotalNum(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != TOTAL_NUM) {
            throw new IllegalArgumentException(CATCH_ERROR + DUPLICATED_NUMBER);
        }
    }
    private static void checkNull(String winNums) {
        if(winNums == null || winNums.isEmpty())
            throw new IllegalArgumentException(CATCH_ERROR + INPUT_EMPTY);
    }

    private static List<Integer> split(String winNums) {
        List<String> numbers = Arrays.asList(winNums.split(SEPARATOR));
        return numbers.stream().map(
                WinningNumDTO::toInteger
        ).collect(Collectors.toList());
    }

    private static Integer toInteger(String number) {
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_NUMBER);
        }
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonus() {
        return bonus;
    }
}
