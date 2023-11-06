package lotto.util;

import java.util.List;

public class Validator {
    public static void validateInputAmount(String amount){
        try{
            Integer.parseInt(amount);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력하세요.");
        }
        if(Integer.parseInt(amount) < 1000){
            throw new IllegalArgumentException("[ERROR] 1000원 이상부터 구매가 가능합니다");
        }
        if(Integer.parseInt(amount) % 1000 != 0){
            throw  new IllegalArgumentException("[ERROR] 로또는 1000원 단위로만 구매가 가능합니다.");
        }
    }
    public static void validateSameNumberCheckStart(List<Integer> numbers){
        for(int i=0; i<numbers.size()-1; i++) {
            for(int j = i+1; j<numbers.size(); j++)
                validateSameNumberCheckFinish(numbers.get(i), numbers.get(j));

        }
    }
    public static void validateSameNumberCheckFinish(Integer num1, Integer num2){
        if(num1 == num2){
            throw new IllegalArgumentException("로또의 숫자가 중복되었습니다. 프로그램 오류입니다");
        }
    }



}
