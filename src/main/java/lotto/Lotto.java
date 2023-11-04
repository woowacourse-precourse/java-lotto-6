package lotto;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public RankEnum checkRank(int bonus, int[] winnerNumber){
        int count = 0;
        for (int lottoNumber : numbers) {
            if (Arrays.binarySearch(winnerNumber, lottoNumber) >= 0) {
                count++;
            }
        }
        if (count == 6){
            return RankEnum.FIRST;
        }
        if (count == 5){
            if (Arrays.binarySearch(winnerNumber, bonus) >= 0){
                return RankEnum.SECOND;
            }
            return RankEnum.THIRD;
        }
        if (count == 4){
            return RankEnum.FORTH;
        }
        if (count == 3){
            return RankEnum.FIFTH;
        }
        return RankEnum.NONE;
    }

}
