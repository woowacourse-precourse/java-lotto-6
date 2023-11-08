package lotto.type;

public enum WinningType {

    THREE_HIT("3개 일치",3, false, 5000),
    FOUR_HIT("4개 일치", 4, false, 50000),
    FIVE_HIT("5개 일치", 5, false,150000),
    FIVE_NO_BONUS_HIT("5개 일치, 보너스 불 일치", 5, true,30000000),
    SIX_HIT("6개 일치", 6, false, 2000000000);

    private String title;
    private int hit;
    private boolean bonusNotHit;
    private int money;

    WinningType(String title, int hit, boolean bonusNotHit, int money) {
        this.title = title;
        this.hit = hit;
        this.bonusNotHit = bonusNotHit;
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public int getHit() {
        return hit;
    }

    public boolean isBonusNotHit() {
        return bonusNotHit;
    }

    public int getMoney() {
        return money;
    }

}
