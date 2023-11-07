package lotto.Controller;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateInput extends Exceptable{
    private static final String SEPERATE = ",";


    public int validateCost(String input){
        int cost = changeInt(canNumber(input));
        validateDivided(cost);
        validateZeroLess(cost);
        return cost;
    }

    public List<Integer> validateWinningNums(String input){
        List<String> strNums = changeList(input);
        return strNums.stream().map(String::trim).map(this::canNumber).map(this::changeInt).collect(Collectors.toList());
    }

    public int validateBonus(String input, List<Integer> winningNums){
        int bonus = changeInt(canNumber(input));
        validateDuplicateBonus(bonus, winningNums);
        validate1to45(bonus);
        return bonus;
    }

    public String canNumber(String input) {
        validateSpace(input);
        validateOverOne(input);
        validatePoint(input);
        validateNumber(input);
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
