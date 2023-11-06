package lotto;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidate {
    public int validateCost(String input){
        int result = changeInt(validateIsNumber(input));
        if (result <= 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0이하가 될 수 없습니다. 다시 입력해주세요.");
        }
        return result;
    }

    public List<Integer> validateWinningNums(String input){
        List<String> strNums = changeList(input);
        return strNums.stream().map(this::validateIsNumber).map(this::changeInt).collect(Collectors.toList());
    }

    public int validateBonus(String input, List<Integer> winningNums){
        int bonus = changeInt(validateIsNumber(input));
        if (winningNums.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되었습니다. 다시 입력해주세요.");
        }
        if (bonus < 1 || bonus > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45사이 입니다. 다시 입력해주세요.");
        }
        return bonus;
    }

    public String validateIsNumber(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            if (input.length() != input.replace(" ", "").length()){
                throw new IllegalArgumentException("[ERROR] 공백이 입력되었습니다. 다시 입력해주세요.");
            }
            if (input.split(",").length > 1){
                throw new IllegalArgumentException("[ERROR] 1개 이상이 입력되었습니다. 다시 입력해주세요.");
            }
            if (input.contains(".")){
                throw new IllegalArgumentException("[ERROR] 소수점은 입력할 수 없습니다. 다시 입력해주세요");
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
