package lotto;

public enum WinningKind {
    FIFTH("3개 일치", 5000),
    FOURTH("4개 일치", 50000),
    THIRD("5개 일치", 1500000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    FIRST("6개 일치", 2000000000);

    private final String explanation;
    private final int price;

    WinningKind(String explanation, int price) {
        this.explanation = explanation;
        this.price = price;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getPrice() {
        return price;
    }
}
