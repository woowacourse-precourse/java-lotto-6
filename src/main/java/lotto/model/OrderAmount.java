package lotto.model;

public class OrderAmount {
    private int money;

    public OrderAmount(int order) {
        this.money = order;
    }

    public int amountOfLotto() {
        return money/1000;
    }

    public double calculateProfit(LottoResults results) {
        return Double.parseDouble(String.format("%1f", results.earning() / money * 100));
    }
}
