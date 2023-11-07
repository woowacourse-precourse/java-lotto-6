package lotto;

public enum Coincidence {
    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE1("5개 일치 (1,500,000원) - "),
    FIVE2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX("6개 일치 (2,000,000,000원) - ");

    final private String coin;
    public String getCoin() {
        return this.coin;
    }
    private Coincidence(String coin) {
        this.coin = coin;
    }
}
