package lotto;

public class Validate {
    public static void validateBonusNum(String input,String WinningNum){
        if(WinningNum.contains(input)){
            throw new IllegalArgumentException("[Error]보너스번호는 중복되지않은 숫자 6개입니다.");
        }
    }
}
