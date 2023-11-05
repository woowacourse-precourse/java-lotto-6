package lotto.data;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchNumbers(WinningNumbers winningNumbers) {
        int count=0;
        for(int i=0;i<numbers.size();i++){
            if(winningNumbers.getWinningNumbers().contains(numbers.get(i))){
                count++;
            }
        }
        return count;
    }

    public boolean isMatchBonusNumber(BonusNumber bonusNumber) {
        if(numbers.contains(bonusNumber.get())){
            return true;
        }
        return false;
    }
}
