package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoGame {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private int[] rank = new int[WinningConditionPrize.values().length];

    public int getRank(WinningConditionPrize winningConditionPrize) {
        return rank[winningConditionPrize.ordinal()];
    }

    public void addRank(WinningConditionPrize winningConditionPrize) {
        this.rank[winningConditionPrize.ordinal()] += 1;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoGame(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if(bonusNumber<0||bonusNumber>45){
            throw new IllegalArgumentException();
        }

        Lotto.checkDuplicate(numbers);
    }

}
