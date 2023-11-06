package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers){
		Set<Integer> duplicated = new HashSet<>(numbers);
        if (duplicated.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    public RankEnum checkRank(List<Integer> winnerNumber, int bonus){
        long count = numbers.stream().filter(winnerNumber::contains).count();
        if (count == RankEnum.FIRST.getMatchCount()) return RankEnum.FIRST;
        if (count == RankEnum.SECOND.getMatchCount()) {
            if (numbers.contains(bonus)) return RankEnum.SECOND;
            return RankEnum.THIRD;
        }
        if (count == RankEnum.FORTH.getMatchCount()) return RankEnum.FORTH;
        if (count == RankEnum.FIFTH.getMatchCount()) return RankEnum.FIFTH;
        return RankEnum.NONE;
    }



}
