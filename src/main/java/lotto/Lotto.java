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

    public Result checkRank(List<Integer> winnerNumber, int bonus){
        int count = 0;

        for (int lottoNumber : numbers) {
            if (winnerNumber.contains(lottoNumber)) {
                count++;
            }
        }

        if (count == 6){
            return new Result(RankEnum.FIRST, 2000000000);
        }
        if (count == 5){
            if (numbers.contains(bonus)){
                return new Result(RankEnum.SECOND, 30000000);
            }
            return new Result(RankEnum.THIRD, 1500000);
        }
        if (count == 4){
            return new Result(RankEnum.FORTH, 50000);
        }
        if (count == 3){
            return new Result(RankEnum.FIFTH, 5000);
        }
        return new Result(RankEnum.NONE, 0);
    }

}
