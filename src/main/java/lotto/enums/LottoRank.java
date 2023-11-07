package lotto.enums;

import java.text.DecimalFormat;

public enum LottoRank {

    FIRST_RANK(1,2_000_000_000,6,false),
    SECOND_RANK(2,30_000_000,5,true),
    THIRD_RANK(3,1_500_000,5,false),
    FOURTH_RANK(4,50_000,4,false),
    FIFTH_RANK(5,5_000,3,false);

    private final int rank;
    private final int money;
    private final int matchNumbers;
    private boolean bonusMatch;

    LottoRank(int rank, int money, int matchNumbers, boolean bonusMatch){
        this.rank = rank;
        this.money = money;
        this.matchNumbers = matchNumbers;
        this.bonusMatch = bonusMatch;
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

    public boolean isBonusMatch(){
        return bonusMatch;
    }

    public String getMoneyToString(){
        return new DecimalFormat("###,###").format(money).toString();
    }
}
