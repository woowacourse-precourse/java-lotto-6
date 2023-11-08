package lotto.domain;

public enum LottoMoney {
    ZERO(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 150_0000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);


    private final int matchNumber;
    private final int money;
    private final boolean matchBonus;

    LottoMoney(int matchNumber, int money, boolean matchBonus) {
        this.matchNumber = matchNumber;
        this.money = money;
        this.matchBonus = matchBonus;
    }

    public static LottoMoney getLotto(int number, boolean bonus) {
        for (LottoMoney lottoMoney : LottoMoney.values()) {
            if (lottoMoney.matchNumber == number && lottoMoney.matchBonus == bonus) {
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
