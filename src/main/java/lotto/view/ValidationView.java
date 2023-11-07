package lotto.view;

public class ValidationView {
    public static int isNumber(String input) throws IllegalArgumentException{
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }
    }
}
