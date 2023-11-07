package lotto;

public enum Coincidence {
    THREE("3개 일치"),
    FOUR("4개 일치"),
    FIVE1("5개 일치"),
    FIVE2("5개 일치, 보너스 볼 일치"),
    SIX("6개 일치");

    private String coin;
    Coincidence(String coin) {
        this.coin = coin;
    }
}
