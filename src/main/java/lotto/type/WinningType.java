package lotto.type;

public enum WinningType {

    THREE_HIT("3개 일치",3, true, 5000),
    FOUR_HIT("4개 일치", 4, true, 50000),
    FIVE_HIT("5개 일치", 5, true,1500000),
    FIVE_NO_BONUS_HIT("5개 일치, 보너스 불 일치", 5, false,30000000),
    SIX_HIT("6개 일치", 6, true, 2000000000);

    private String title;
    private int hit;
    private boolean isBonusHit;
    private int money;

    WinningType(String title, int hit, boolean isBonusHit, int money) {
        this.title = title;
        this.hit = hit;
        this.isBonusHit = isBonusHit;
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public int getHit() {
        return hit;
    }

    public boolean isBonusHit() {
        return isBonusHit;
    }

    public int getMoney() {
        return money;
    }

}
