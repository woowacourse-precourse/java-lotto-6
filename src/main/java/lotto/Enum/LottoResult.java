package lotto.Enum;

public enum LottoResult {
    THREE(5000, "3개 일치 (5,000원)"),
    FOUR(50000, "4개 일치 (50,000원)"),

    FIVE_WITH_NO_BONUS(1500000, "5개 일치 (1,500,000원)"),
    FIVE_WITH_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(2000000000, "6개 일치 (2,000,000,000원)");
    private final int money;
    private final String description;

    private LottoResult(int money, String description){
        this.money = money;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public int getMoney(){
        return money;
    }

}
