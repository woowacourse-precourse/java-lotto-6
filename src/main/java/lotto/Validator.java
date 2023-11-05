package lotto;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static final String regexSixNumber = "^[0-9,]*";
    public static final String regexNumber = "^[0-9]{1,2}";
    public List<Integer> validatePickSixNumber(String rawInput){
        validateNumberList(rawInput);
        List<Integer> numbers = Arrays.stream(rawInput.split(","))
                .map(Integer::parseInt)
                .toList();
        validateDuplicateSix(numbers);
        validateCount(numbers);
        numbers.forEach(this::validateRange);
        return numbers;
    }
    public Integer validatePickBonusNumber(String rawInput,List<Integer> sixNumber){
        validateNumber(rawInput);
        Integer number = Integer.parseInt(rawInput);
        validateRange(number);
        validateDuplicateSeven(number,sixNumber);
        return number;
    }
    public Integer validateBuyAmount(String rawInput){
        validateNumber(rawInput);
        Integer amount = Integer.parseInt(rawInput);
        validateModuler(amount);
        return amount;
    }

    public void validateNumberList(String input){
    if(!input.matches(regexSixNumber)){
        throw new IllegalArgumentException("[ERROR] 로또 번호를 정확히 입력하세요.");
    }
}
    public void validateDuplicateSix(List<Integer> input){
        if(input.stream().distinct().count()!=input.size()){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }
    public void validateDuplicateSeven(Integer input,List<Integer> sixNumber){
        if(sixNumber.contains(input)){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 존재합니다.");
        }
    }
    public void validateCount(List<Integer> input){
        if(input.size()!=6){
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력하세요.");
        }
    }
    public void validateNumber(String input){
        if(!input.matches(regexNumber)){
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력하세요.");
        }
    }
    public void validateRange(Integer input){
        if(input>45||input<1){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public void validateModuler(Integer input){
        if(input%1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또 한장은 1000원 입니다. 1000원 단위로 입력하세요.");
        }
    }
}
