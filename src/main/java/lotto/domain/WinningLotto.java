package lotto.domain;

import java.util.List;

public class WinningLotto {

    List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
        // if thre is a number that is not in the range of 1 to 45
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }




}
