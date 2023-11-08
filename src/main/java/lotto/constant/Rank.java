package lotto.constant;

public enum Rank {
    SAME_NUMBER_3(3, "5,000"),
    SAME_NUMBER_4(4, "50,000"),
    SAME_NUMBER_5_BONUSE_O(5, "30,000,000"),
    SAME_NUMBER_5_BONUSE_X(5, "1,500,000"),
    SAME_NUMBER_6(6, "2,000,000,000");

    private final int sameNumber;
    private final String price;

    Rank(int sameNumber, String price) {
        this.sameNumber = sameNumber;
        this.price = price;

    }

    public String getMessage() {

        return String.format("%d개 일치 (%s원)", sameNumber, price);
    }

    public String getMessageBonusO(int num) {

        if (num == 0) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", sameNumber, price);
        }
        return String.format("%d개 일치, 보너스 일치 (%s원)", sameNumber, price);

    }

    public int getPrice() {
        String result = price.replace(",", "");
        return Integer.parseInt(result);
    }
}
