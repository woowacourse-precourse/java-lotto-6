package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;

public class Parser {

    public static Budget parseToBudget(String budget) {
        try {
            return new Budget(Integer.parseInt(budget));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BUDGET_NON_NUMERIC.getMessage());
        }
    }

    public static Lotto parseToLotto(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static Bonus parseToBonus(String input) {
        int parsedInput = Integer.parseInt(input);
        return new Bonus(parsedInput);
    }


}
