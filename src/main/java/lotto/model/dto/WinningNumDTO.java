package lotto.model.dto;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.ExceptionMessages;

public class WinningNumDTO {
    private static final String SEPARATOR = ",";
    private List<Integer> wins;
    private int bonus;
    private WinningNumDTO(List<Integer> wins, int bonus) {
        this.wins = wins;
        this.bonus = bonus;
    }

    public static WinningNumDTO of(String winNums, String bonus) {
        List<Integer> numbers = split(winNums);
        return new WinningNumDTO(numbers, toInteger(bonus));
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
}
