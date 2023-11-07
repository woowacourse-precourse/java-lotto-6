package lotto.game;

import lotto.enums.LottoRank;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public LottoRank getLottoRank(List<Integer> winningNumbers, int bonusNumber) {
        int hit = 0;
        boolean bonusNumberFlag = false;

        for(int number : this.numbers) {
            if(winningNumbers.contains(number)) {
                hit++;
            }

            if(number == bonusNumber) {
                bonusNumberFlag = true;
            }
        }

        return getRank(hit, bonusNumberFlag);
    }

    private LottoRank getRank(int hit, boolean bonusNumberFlag) {
        if(hit == 3)  return LottoRank.THIRD;
        if(hit == 4)  return LottoRank.FOURTH;
        if(hit == 5 && !bonusNumberFlag)  return LottoRank.FIFTH_WITHOUT_BONUS;
        if(hit == 5 && bonusNumberFlag)  return LottoRank.FIFTH_WITH_BONUS;
        if(hit == 6) return LottoRank.SIXTH;
        else return LottoRank.NONE;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
