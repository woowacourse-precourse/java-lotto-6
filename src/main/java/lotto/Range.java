package lotto;

public enum Range {
    ZERO(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    START(1),
    END(45),
    COUNT(6),
    UNIT(1000),
    MATCH3PRICE(5_000),
    MATCH4PRICE(50_000),
    MATCH5PRICE(1_500_000),
    MATCH5WITHBONUSPRICE(30_000_000),
    MATCH6PRICE(2_000_000_000);

    private final Integer content;

    Range(Integer content) {
        this.content = content;
    }

    public Integer content() {
        return content;
    }
}
