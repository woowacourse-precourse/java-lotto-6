package lotto.utility;

public class Utility {
    public int makeStringToInt(String Input) {
        try {
            int number = Integer.parseInt(Input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }
}
