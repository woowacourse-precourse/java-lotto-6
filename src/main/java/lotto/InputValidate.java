package lotto;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
public class InputValidate {
    public int validateCost(String input){
        return changeInt(validateIsNumber(input));
    }

    public String validateIsNumber(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다. 프로그램이 종료됩니다.");
        }
        return input;
    }

    public int changeInt(String s){
        return parseInt(s);
    }

    public List<String> changeList(String input){
        List<String> splitNums = Arrays.asList(input.split(","));
        isThereGap(splitNums);
        return splitNums;
    }

    private boolean isThereGap(List<String> nums){
        nums.stream().map(this::validateIsNumber);
        return true;
    }


}
