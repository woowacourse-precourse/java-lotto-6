package lotto.model;

public enum Prize {
    FIRST(6, 2_000_000_000, "6개 일치", 0),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치", 0, true),
    THIRD(5, 1_500_000, "5개 일치",0),
    FOURTH(4, 50_000, "4개 일치",0),
    FIFTH(3, 5_000, "3개 일치",0),
    NONE(0, 0,"",0);

    private int match;
    private int price;
    private String message;
    private int count;
    private boolean hasBonus;

    Prize(int match, int price, String message,int count) {
        this(match, price, message, count, false);
    }

    Prize(int match, int price, String message, int count, boolean hasBonus) {
    }

    public void increaseCount(Prize prize) {
        prize.count++;
    }

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }
}
