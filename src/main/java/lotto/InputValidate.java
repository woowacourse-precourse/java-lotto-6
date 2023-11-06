package lotto;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidate {
    private static final String SEPERATE = ",";
    private ValidateTools validateTools;
    public InputValidate(ValidateTools validateTools){
        this.validateTools = validateTools;
    }
    public int validateCost(String input){
        int cost = changeInt(canNumber(input));
        validateTools.validateDivided(cost);
        validateTools.validateZeroLess(cost);
        return cost;
    }

    public List<Integer> validateWinningNums(String input){
        List<String> strNums = changeList(input);
        return strNums.stream().map(String::trim).map(this::canNumber).map(this::changeInt).collect(Collectors.toList());
    }

    public int validateBonus(String input, List<Integer> winningNums){
        int bonus = changeInt(canNumber(input));
        validateTools.validateDuplicateBonus(bonus, winningNums);
        validateTools.validate1to45(bonus);
        return bonus;
    }

    public String canNumber(String input) {
        validateTools.validateSpace(input);
        validateTools.validateOverOne(input);
        validateTools.validatePoint(input);
        validateTools.validateNumber(input);
        return input;
    }

    public int changeInt(String s){
        return parseInt(s);
    }


    public List<String> changeList(String input){
        List<String> splitNums = Arrays.asList(input.split(SEPERATE));
        return splitNums;
    }

}
