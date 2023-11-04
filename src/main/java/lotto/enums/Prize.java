package lotto.enums;

import java.text.DecimalFormat;

public enum Prize {

    FIRST_RANK(1,2_000_000_000,6),
    SECOND_RANK(2,30_000_000,5),
    THIRD_RANK(3,1_500_000,5),
    FOURTH_RANK(4,50_000,4),
    FIFTH_RANK(5,5_000,3);


    private final int rank;
    private final int money;
    private final int matchNumbers;

    Prize(int rank, int money, int matchNumbers){
        this.rank = rank;
        this.money = money;
        this.matchNumbers = matchNumbers;
    }

    public int getRank(){
        return rank;
    }

    public int getMoney(){
        return money;
    }

    public int getMatchNumbers(){
        return matchNumbers;
    }

    public String getMoneyToString(){
        return new DecimalFormat("###,###").format(money).toString();
    }
}
