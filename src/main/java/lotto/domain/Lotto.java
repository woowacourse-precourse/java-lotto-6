package lotto.domain;

import lotto.util.LottoRank;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!(isDuplicated(numbers) && numbers.size() == 6)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        int size = numbers.size();
        return size == numbers.stream()
                .distinct()
                .count();
    }

    public LottoRank getLottoRank(List<Integer> winningNumbers, int bonusNumber){
        int matchCount = checkWinningNumbers(winningNumbers);
        return LottoRank.calculateRank(matchCount,checkBonusNumber(bonusNumber) );
    }
    public int checkWinningNumbers(List<Integer> winningNumber) {
        int matchCount = 0;

        for (int number : winningNumber) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean checkBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }


}









