package lotto.model;

import lotto.constant.MessageConstant;

public enum Prize {

    FIFTH(3, 5_000, MessageConstant.MESSAGE_FIFTH,0),
    FOURTH(4, 50_000, MessageConstant.MESSAGE_FOURTH,0),
    THIRD(5, 1_500_000, MessageConstant.MESSAGE_THIRD,0),
    SECOND(5, 30_000_000, MessageConstant.MESSAGE_SECOND, 0, true),
    FIRST(6, 2_000_000_000, MessageConstant.MESSAGE_FIRST, 0),
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
        this.match = match;
        this.price = price;
        this.message = message;
        this.count = count;
        this.hasBonus = hasBonus;
    }

    public void increaseCount(Prize prize) {
        prize.count++;
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

}
