package lotto.model;

import java.util.Map;

public class Wallet {
    private final int initialAmount;
    private int money;

    public Wallet(String money) {
        validateMoney(money);
        initialAmount = convertStringToInt(money);
        this.money = initialAmount;
    }

    private void validateMoney(String money) {
        validateNotNullMoney(money);
        validateNonNumericMoney(money);
        validateNotDivisionMoney(money);
        validateOutOfRangeMoney(money);
    }

    public boolean canBuyLotto() {
        return money - LottoGameSettingConstValue.LOTTO_PRICE.getValue() >= 0;
    }

    public void buyLotto() {
        money -= LottoGameSettingConstValue.LOTTO_PRICE.getValue();
    }

    private void validateNonNumericMoney(String money) {
        if (!money.matches("^[0-9]*")) {
            throw new IllegalArgumentException(Exception.NON_NUMERIC_MONEY_ERROR.getMessage());
        }
    }

    private void validateNotNullMoney(String money) {
        if (money == null) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_MONEY_ERROR.getMessage());
        }
    }

    private void validateOutOfRangeMoney(String money) {
        int convertMoney = convertStringToInt(money);

        if (convertMoney > LottoGameSettingConstValue.MAXIMUM_PURCHASE_AMOUNT.getValue()) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_MONEY_ERROR.getMessage());
        }
    }

    private void validateNotDivisionMoney(String money) {
        int convertMoney = convertStringToInt(money);

        if (convertMoney == 0 || convertMoney % LottoGameSettingConstValue.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_MONEY_ERROR.getMessage());
        }
    }

    private int convertStringToInt(String money) {
        int convertMoney;

        try {
            convertMoney = Integer.parseInt(money);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_MONEY_ERROR.getMessage());
        }
        return convertMoney;
    }

    public double calculateProfitRate(long profit) {
        if (profit == 0) {
            return 0.0;
        }
        return Math.round((((double)profit * 100) / (double)initialAmount) * 10.0) / 10.0;
    }

    public long calculateProfit(Map<Integer, Integer> lottoesResult) {
        long profit = 0;

        for (int rank = 1; rank <= 5; rank++) {
            profit += (long) lottoesResult.get(rank) * LottoGameSettingConstValue.FIRST_PRIZE_MONEY.getPrizeMoney(rank);
        }
        return profit;
    }
}
