package lotto.settings;

public enum WinningAmount {
    FIRST("2,000,000,000"),
    SECOND("30,000,000"),
    THIRD("1,500,000"),
    FOURTH("50,000"),
    FIFTH("5,000");

    private final String prize;

    WinningAmount(String prize) {
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }

    public static int size(){
        return WinningAmount.values().length;
    }

    public Integer getIntPrize(){
        String s = prize.replaceAll(",", "");
        return Integer.parseInt(s);
    }
}
