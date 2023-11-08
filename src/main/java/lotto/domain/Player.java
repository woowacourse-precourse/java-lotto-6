package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
    private int purChaseAmount;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private double rateOfReturn;

    public void insertPurchaseAmount(int purChaseAmountInput) {
        this.purChaseAmount = purChaseAmountInput;
    }

    public void insertWinningNumbers(String numbers) {
        this.winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::valueOf)
                .toList();
    }

    public void insertBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getPurChaseAmount() {
        return purChaseAmount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void calculateRateOfReturn(double totalReturn) {
        double rawRate = (totalReturn / purChaseAmount) * 100.0;
        rateOfReturn = Math.round(rawRate * 100.0) / 100.0;
    }
}
