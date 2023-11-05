package lotto.variables;

public enum LottoVariables {
    LOTTO_FIRST(2000000000 , "1등: 6개 번호 일치"),
    LOTTO_SECOND(30000000, "2등: 5개 번호 + 보너스 번호 일치"),
    LOTTO_THIRD(1500000, "3등: 5개 번호 일치"),
    LOTTO_FOURTH(50000, "4등: 4개 번호 일치"),
    LOTTO_FIFTH(5000, "5등: 3개 번호 일치");

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
