package lotto.model;

import java.util.Arrays;

public enum LottoPrice {
    FIRST_PRICE(1, 2_000_000_000),
    SECOND_PRICE(2, 30_000_000),
    THIRD_PRICE(3, 1_500_000),
    FOURTH_PRICE(4, 50_000),
    FIFTH_PRICE(5, 5_000),
    OTHER_PRICE(0, 0);

    private final int rank;
    private final int price;

    LottoPrice(int rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    public static LottoPrice matchLottoPrice(int rank) {
        return Arrays.stream(values())
                .filter(lottoPrice -> lottoPrice.rank == rank)
                .findAny()
                .orElse(OTHER_PRICE);
    }

    public int getPrice() {
        return price;
    }
}
