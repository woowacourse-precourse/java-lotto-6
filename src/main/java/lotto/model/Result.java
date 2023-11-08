package lotto.model;

import lotto.view.Output;

public enum Result {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    private int count;
    private int price;
    private String message;
    private static final String ERROR = "[ERROR]";
    private static final int MIN_COUNT = 3;

    Result(int count, int price, String message) {
        this.count = count;
        this.price = price;
        this.message = message;
    }

    public static Result valueOf(int count, boolean is_bonus) {
        if (count < MIN_COUNT) {
            return MISS;
        }
        if (SECOND.match(count) && is_bonus) {
            return SECOND;
        }

        for (Result r : values()) {
            if (r.match(count) && r != SECOND) {
                return r;
            }
        }
        throw new IllegalArgumentException(ERROR);
    }

    public int get_Count() {
        return this.count;
    }

    public int get_Price() {
        return this.price;
    }

    public boolean match(int count) {
        return this.count == count;
    }

    public void show_Result(int count) {
        if (this != MISS) {
            Output.show_Winning_Status(message, count);
        }
    }
}
