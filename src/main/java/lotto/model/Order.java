package lotto.model;

import lotto.constant.OutputMessage;
import lotto.constant.ValidatorMessage;

public class Order {
    private static int LOTTO_PRICE = 1000;

    private final int cost;
    private int buyCount;

    public Order(String inputCost) {
        this.cost = convertStringToInteger(inputCost);

        validate(this.cost);

        this.buyCount = this.cost / LOTTO_PRICE;
    }

    public int getBuyCount() {
        return this.buyCount;
    }

    private int convertStringToInteger(String cost) {
        validateIsNull(cost);
        validateIsNumeric(cost);

        return Integer.parseInt(cost);
    }

    public LottoTicket buy() {
        return LottoTicket.createLottoTicket(this.buyCount);
    }

    public void validate(int cost) {
        validateIsPositive(cost);
        validateMultipleOfThousand(cost);
    }
    public String getBuyCountToString() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(this.buyCount)
                .toString();
    }

    public String getResult(WinStatistics winStatistics) {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(OutputMessage.TOTAL_PROFIT_RATE_MESSAGE)
                .append(calculateProfitRate(winStatistics))
                .append(OutputMessage.RESULT_SUFFIX)
                .toString();
    }

    private double calculateProfitRate(WinStatistics winStatistics) {
        double profitRate = ((winStatistics.sum() - this.cost) / (this.cost)) * 100;

        if(profitRate < 0.0) {
            profitRate += 100;
        }

        return Math.round((profitRate * 100.0) / 1.0) / 100.0;
    }


    private void validateIsNumeric(String cost) {
        if (!cost.matches("^\\d+$")) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_INPUT_NUMERIC);
        }
    }

    private void validateIsPositive(int cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_COST_POSITIVE);
        }
    }

    private void validateMultipleOfThousand(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_LOTTO_COST);
        }
    }

    private void validateIsNull(String cost){
        if(cost == null || cost.isEmpty()) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_IS_NULL);
        }
    }
}
