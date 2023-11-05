package lotto.dto;

import java.util.Arrays;
import java.util.List;

public class LottoDto {

    private int lottoPurchaseAmount;
    private List<Integer> winningNumbers;
    private int BonusNumber;

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }

    public void setLottoPurchaseAmount(String lottoPurchaseAmount) {
        this.lottoPurchaseAmount = Integer.parseInt(lottoPurchaseAmount);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

    }

    public int getBonusNumber() {
        return BonusNumber;
    }

    public void setBonusNumber(String inputBonusNumber) {
        this.BonusNumber = Integer.parseInt(inputBonusNumber);
    }
}
