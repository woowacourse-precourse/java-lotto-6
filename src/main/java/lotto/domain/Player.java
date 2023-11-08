package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
    private int purChaseAmount;
    private List<Integer> winningNumbers;

    public void insertPurchaseAmount(int purChaseAmountInput) {
        this.purChaseAmount = purChaseAmountInput;
    }

    public void insertWinningNumbers(String numbers) {
        this.winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::valueOf)
                .toList();
    }
    
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getPurChaseAmount() {
        return purChaseAmount;
    }

    public double calculateRateOfReturn(double totalReturn) {
        double rateOfReturn = (totalReturn / purChaseAmount) * 100.0;
        rateOfReturn = Math.round(rateOfReturn * 100.0) / 100.0;

        return rateOfReturn;
    }
}
