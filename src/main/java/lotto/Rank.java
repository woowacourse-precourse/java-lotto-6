package lotto;

public enum Rank {
    fifth(5000),
    fourth(50_000),
    third(1_500_000),
    second(30_000_000),
    first(2_000_000_000)
    ;

    int price;
    Rank(int price) {
        this.price = price;
    }
}
