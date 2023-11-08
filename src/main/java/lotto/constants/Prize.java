package lotto.constants;

public enum Prize {
    NONE(5, 0, ""),
    FIFTH(4, 5000, "3개 일치 (5,000원)"),
    FOURTH(3, 50000, "4개 일치 (50,000원)"),
    THIRD(2, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(0, 2000000000, "6개 일치 (2,000,000,000원)");
    private final int index;
    private final int price;
    private final String message;

    Prize(int index, int price, String message) {
        this.index = index;
        this.price = price;
        this.message = message;
    }

    public int getIdx(){
        return index;
    }
    public int getPrice(){
        return price;
    }
    public String getMessage(){
        return message;
    }

}
