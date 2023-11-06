package lotto;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidate {
    public String isThereGap(String input) {
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
        String[] splitNums = input.split(",");
        return Arrays.stream(splitNums).collect(Collectors.toList());
    }


}
