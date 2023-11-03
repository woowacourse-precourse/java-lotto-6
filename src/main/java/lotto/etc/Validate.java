package lotto.etc;

public class Validate {

    public static int validateNumber(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalStateException("[ERROR] 숫자가 아닌 값이 들어왔습니다.");
        }
    }
}
