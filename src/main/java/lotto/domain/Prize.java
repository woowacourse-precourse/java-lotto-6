package lotto.domain;

public enum Prize {
    FIRST(0, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(7, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(2, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    FAIL(4, 0, "");

    private final int index;
    private final int price;
    private final String printResult;

    Prize(int index, int price, String printResult) {
        this.index = index;
        this.price = price;
        this.printResult = printResult;
    }

    public int getIndex() {
        return index;
    }

    public int getPrice() {
        return price;
    }

    public String getPrintResult() {
        return printResult;
    }
}
