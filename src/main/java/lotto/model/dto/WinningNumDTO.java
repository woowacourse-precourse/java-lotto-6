package lotto.model.dto;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.DUPLICATED_NUMBER;
import static lotto.constants.ExceptionMessages.DUPLICATED_WITH_WINNING_NUM;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;
import static lotto.constants.ExceptionMessages.INVALID_RANGE;
import static lotto.constants.ExceptionMessages.INVALID_TOTAL_NUMBER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constants.ExceptionMessages;
import lotto.model.validator.WinningNumValidator;

public class WinningNumDTO {
    private static final String SEPARATOR = ",";
    private List<Integer> winningNums;
    private int bonus;
    private WinningNumDTO(List<Integer> winningNums, int bonus) {
        this.winningNums = winningNums;
        this.bonus = bonus;
    }

    public static WinningNumDTO of(String winText, String bonusText) {
        List<Integer> winningNums = split(winText);
        int bonusNum = Integer.parseInt(bonusText);
        return new WinningNumDTO(winningNums, bonusNum);
    }
    private static List<Integer> split(String winNums) {
        List<String> numbers = Arrays.asList(winNums.split(SEPARATOR));
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }






    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonus() {
        return bonus;
    }
}
