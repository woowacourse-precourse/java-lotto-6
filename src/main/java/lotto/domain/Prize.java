package lotto.domain;

public enum Prize {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    FAIL(0, 0, "");

    private final int count;
    private final int price;
    private final String printResult;

    Prize(int count, int price, String printResult) {
        this.count = count;
        this.price = price;
        this.printResult = printResult;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public String getPrintResult() {
        return printResult;
    }
}
