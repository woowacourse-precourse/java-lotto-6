package lotto.variables;

public enum LottoVariables {
    LOTTO_FIRST(2000000000 , "6개 일치 (2,000,000,000원)"),
    LOTTO_SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    LOTTO_THIRD(1500000, "5개 일치 (1,500,000원)"),
    LOTTO_FOURTH(50000, "4개 일치 (50,000원)"),
    LOTTO_FIFTH(5000, "3개 일치 (5,000원)");

    private int price;

    private String description;

    private LottoVariables(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
