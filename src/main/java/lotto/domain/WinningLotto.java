package lotto.domain;

import lotto.domain.PickLotto;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers;   //입력 할 당첨 번호

    public WinningLotto(List<Integer> numbers) {
        isDuplicate(numbers);
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void isDuplicate(List<Integer> numbers){
        HashSet<Integer> sizeCheck = new HashSet<>(numbers);
        if(sizeCheck.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
