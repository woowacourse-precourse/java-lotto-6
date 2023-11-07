package lotto.domain;

public enum LottoMoney {
    ZERO(0,0,false),
    FIFTH(3,5000,false),
    FOURTH(4,50000,false),
    THIRD(5,1500000,false),
    SECOND(5,30000000, true),
    FIRST(6,2000000000,false);


    private final int matchNumber;
    private final int money;
    private boolean matchBonus;

    LottoMoney(int matchNumber, int money, boolean matchBonus) {
        this.matchNumber = matchNumber;
        this.money = money;
        this.matchBonus = matchBonus;
    }

    public static LottoMoney getLotto(int number, boolean bonus){
        for(LottoMoney lottoMoney : LottoMoney.values()){
            if(lottoMoney.matchNumber == number && lottoMoney.matchBonus == bonus){
                return lottoMoney;
            }
        }
        return ZERO;
    }

    public int getMatchCount() {
        return matchNumber;
    }


    public int getMoney() {
        return money;
    }
}
