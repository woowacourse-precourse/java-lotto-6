package lotto.view;

public class ValidationView {
    private static final int LOTTO_PRICE = 1000;
    public static int isNumber(String input) throws IllegalArgumentException{
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }
    }
    public static void isDivided(String input){
        int money = Integer.parseInt(input);
        if ((money % LOTTO_PRICE) != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 구매할 수 있습니다.");
        }
    }
}
