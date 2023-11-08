package lotto;

import java.util.List;

public class CommonFunction {
    // 하나의 번호가 [1, 45] 구간에 있는지 확인
    public static void checkNumberIn1to45(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    // 번호가 모두 [1, 45] 구간에 있는지 확인
    public static void checkNumbersIn1to45(List<Integer> numbers){
        for(Integer number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    // 문자열 입력값이 정수인지 확인하여 변환
    public static int convertToInt(String input_amount){
        try {
            return Integer.parseInt(input_amount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 정수가 아닙니다. 1000원 단위의 자연수를 입력해주세요.");
        }
    }

}
