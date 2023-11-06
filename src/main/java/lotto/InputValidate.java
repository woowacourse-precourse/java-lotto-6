package lotto;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidate {
    public int validateNumber(String input){
        return changeInt(validateIsNumber(input));
    }

    public List<Integer> validateWinningNums(String input){
        List<String> strNums = changeList(input);
        return strNums.stream().map(this::validateIsNumber).map(this::changeInt).collect(Collectors.toList());
    }

    public String validateIsNumber(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            if (input.length() != input.replace(" ", "").length()){
                throw new IllegalArgumentException("[ERROR] 공백이 입력되었습니다. 다시 입력해주세요.");
            }
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다. 다시 입력해주세요.");
        }
        return input;
    }

    public int changeInt(String s){
        return parseInt(s);
    }

    public List<String> changeList(String input){
        List<String> splitNums = Arrays.asList(input.split(","));
        splitNums.stream().map(this::validateIsNumber);
        return splitNums;
    }

}
