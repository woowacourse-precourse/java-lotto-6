package lotto.constant;

public enum LottoRank {
    FIVE_RANK(3, 5_000)
    , FOUR_RANK(4, 50_000)
    , THIRD_RANK(5, 1_500_000)
    , SECOND_RANK(50, 30_000_000)
    , FIRST_RANK(6, 2_000_000_000);

    private final int count_correct_number;

    private final int price;

    LottoRank(int count_correct_number, int price) {
        this.count_correct_number = count_correct_number;
        this.price = price;
    }

    public int getCount_correct_number() {
        return count_correct_number;
    }

    public int getPrice() {
        return price;
    }

}
