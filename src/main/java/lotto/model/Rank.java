package lotto.model;


public enum Rank {
    NONE(0, 0, false, "미일치"),
    FIFTH(5000, 3, false, "3개 일치 (5,000원)"),
    FOURTH(50000, 4, false, "4개 일치 (50,000원)"),
    THIRD(1500000, 5, false, "5개 일치 (1,500,000원)"),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(2000000000, 6, false,  "6개 일치 (2,000,000,000원)");

    private int price;
    private int match;
    private boolean bonus;
    private String result;

    Rank(int price, int match, boolean bonus, String result) {
        this.price = price;
        this.match = match;
        this.bonus = bonus;
        this.result = result;
    }

    public static Rank match(int match, boolean bonus) {

        for (Rank rank : Rank.values()) {
            if (rank.match == match && rank.bonus == bonus) {
                return rank;
            }
        }

        return Rank.NONE;
    }

    public int getPrice(){
        return price;
    }

    public String getResult() {
        return result;
    }
}