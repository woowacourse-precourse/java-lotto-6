package lotto.view;

public class Exceptions {
    void checkType (String given) {
        try{
            int test = Integer.parseInt(given);
        }
        catch (NumberFormatException n) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
