package lotto.util;

import java.util.List;

public class Validator {
    //1,000으로 나누어 떨어지지 않는 경우
    public static void notSeparatedBy1000(int amount){
        if(amount %1000 != 0){
            throw new IllegalArgumentException("구입 금액에 1,000보다 작은 단위가 있습니다.");
        }
    }

    //숫자가 아닌 경우
    public static void isDigit(String number){
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    //숫자가 아닌 경우-리스트 버전
    public static void isDigit(List<String> numbers){
        try{
            for(String number:numbers){
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("로또 번호 중 숫자가 아닌 입력이 있습니다.");
        }
    }
    //1 ~ 45 범위를 초과하는 경우
    //1 ~ 45 범위를 초과하는 경우-리스트 버전
    //중복된 숫자가 포함된 경우 - 리스트
}
