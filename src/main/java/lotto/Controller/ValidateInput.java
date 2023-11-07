package lotto.Controller;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateInput {
    private static final String SEPERATE = ",";
    private Exceptable exceptable;
    public ValidateInput(Exceptable exceptable){
        this.exceptable = exceptable;
    }
    public int validateCost(String input){
        int cost = changeInt(canNumber(input));
        exceptable.validateDivided(cost);
        exceptable.validateZeroLess(cost);
        return cost;
    }

    public List<Integer> validateWinningNums(String input){
        List<String> strNums = changeList(input);
        return strNums.stream().map(String::trim).map(this::canNumber).map(this::changeInt).collect(Collectors.toList());
    }

    public int validateBonus(String input, List<Integer> winningNums){
        int bonus = changeInt(canNumber(input));
        exceptable.validateDuplicateBonus(bonus, winningNums);
        exceptable.validate1to45(bonus);
        return bonus;
    }

    public String canNumber(String input) {
        exceptable.validateSpace(input);
        exceptable.validateOverOne(input);
        exceptable.validatePoint(input);
        exceptable.validateNumber(input);
        return input;
    }

    private int changeInt(String s){
        return parseInt(s);
    }


    private List<String> changeList(String input){
        List<String> splitNums = Arrays.asList(input.split(SEPERATE));
        return splitNums;
    }

}
