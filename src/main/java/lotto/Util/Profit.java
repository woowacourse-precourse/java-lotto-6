package lotto.Util;

public class Profit {
    public static float getProfit(float nowMoney, float pastMoney) {
        //System.out.println(nowMoney + "\n" + pastMoney);
        return nowMoney / pastMoney * 100;
    }
}
