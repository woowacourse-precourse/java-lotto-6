package lotto.util;

public class InputVaildate {
    private final static int MONEY_UNIT = 1000;
    public static void moneyVaildate(int money) {
        //1000단위인 지 검증
        isUnitMoney(money);
    }
    public static  void isUnitMoney(int money) {
        if(money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로만 가능합니다.");
        }
    }
}
