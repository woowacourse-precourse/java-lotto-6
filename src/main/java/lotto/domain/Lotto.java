package lotto.domain;

import java.util.List;
import lotto.code.ExceptionMessage;

public class Lotto {
    private final static int MIN_WIN_NUMBER = 3;
    private final List<Integer> numbers;
    private Rank rank;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public void setRank(int count) {
        if(count >= MIN_WIN_NUMBER) {
            rank = Rank.getRank(count);
            Rank.addRankCount(rank);
        }
    }

    public void matchBonusNumber(int bonusNumber) {
        if(rank == Rank.THIRD && numbers.contains(bonusNumber)) {
            Rank.minusThirdRankCount();
            rank = Rank.SECOND;
            Rank.addRankCount(rank);
        }
    }
}
