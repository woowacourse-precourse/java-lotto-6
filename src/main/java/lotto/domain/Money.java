package lotto.domain;

public class Money {
    private static final Integer LOTTOPRICE = 1000;
    public static int countMoney(Integer money){
        int count;
        count = money / LOTTOPRICE;
        return count;
    }
}
