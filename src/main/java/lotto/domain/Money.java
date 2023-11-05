package lotto.domain;

public class Money {
    private static final Integer LOTTOPRICE = 1000;
    public int countMoney(Integer money){
        int count;
        count = money / LOTTOPRICE;
        System.out.println(count);
        return count;
    }
}
