package lotto.model;

public class Order {
    private static int LOTTO_PRICE = 1000;

    private final int cost;
    private int buyCount;

    public Order(String inputCost) {

    }

    public int getBuyCount() {

    }

    private int convertStringToInteger(String cost) {

    }

    public LottoTicket buy() {

    }

    public void validate(int cost) {
        validateIsPositive(cost);
        validateMultipleOfThousand(cost);
    }
    public String getBuyCountToString() {

    }

    public String getResult(WinStatistics winStatistics) {

    }

    private double calculateProfitRate(WinStatistics winStatistics) {

    }


    private void validateIsNumeric(String input) {

    }

    private void validateIsPositive(int cost) {

    }

    private void validateMultipleOfThousand(int cost) {

    }
}
