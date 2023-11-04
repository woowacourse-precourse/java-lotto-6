package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    public static final String regexSixNumber = "^[0-9,]*";
    public static final String regexNumber = "^[0-9]{1,2}";
    public List<Integer> pickSixNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumberList(input);
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        validateDuplicate(numbers);
        numbers.forEach(this::validateRange);
        return numbers;
    }
    public Integer pickBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        Integer number = Integer.parseInt(input);
        validateRange(number);
        return number;
    }
    public Integer buyAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        Integer amount = Integer.parseInt(input);
        validateModuler(amount);
        return amount;
    }
    public void validateNumberList(String input){
        if(!input.matches(regexSixNumber)){
            throw new IllegalArgumentException("[ERROR] 로또 번호를 정확히 입력하세요.");
        }
    }
    public void validateDuplicate(List<Integer> input){
        if(input.stream().distinct().count()!=input.size()){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
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
