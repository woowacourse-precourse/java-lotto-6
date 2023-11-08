package lotto;

public class Exception {
    public static boolean isValidMoney(int money){
        return money >= 1000 && money % 1000 == 0;
    }
}
