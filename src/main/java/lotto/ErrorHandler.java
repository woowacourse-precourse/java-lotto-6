package lotto;

public class ErrorHandler {

    public void checkIfNumber(String nums) {
        if(nums.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] " + nums + "는 숫자가 아닙니다.");
        }
    }
}
