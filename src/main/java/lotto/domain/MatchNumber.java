package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchNumber {

    private final List<Integer> matchNumbers;

    private static String COMMA_DELIMITER = ",";

    public MatchNumber(String userInput){
        this.matchNumbers = validate(userInput);
    }

    private List<Integer> validate(String userInput) {
        List<String> inputNumbers = Arrays.asList(userInput.split(COMMA_DELIMITER));
        inputSizeCheck(inputNumbers);

        return dataTypeValidate(inputNumbers);
    }

    private void inputSizeCheck(List<String> inputNumbers){
        if(inputNumbers.size()!=6){
            throw new IllegalArgumentException("[ERROR] ','를 구분자로 6개의 숫자를 공백 없이 입력해 주세요");
        }
    }

    private List<Integer> dataTypeValidate(List<String> inputNumbers){
        List<Integer> matchNumbers = new ArrayList<>();
        try{
            for(String inputNumber : inputNumbers){
                matchNumbers.add(Integer.parseInt(inputNumber.trim()));
            }
            return matchNumbers;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 형식에 맞지 않습니다.");
        }
    }

}
