package lotto.Model;

import java.util.List;
import lotto.Model.VO.LottoData;

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

    public Prize calculatePrize(List<Integer> answer,Integer bonusNumber){
        int matchCount = calculateMatchCount(answer);
        boolean isBonusMatch = numbers.contains(bonusNumber);


        if (matchCount == 6) {
            return Prize.FIRST;
        }
        if (matchCount == 5 && isBonusMatch) {
            return Prize.SECOND;
        }
        if (matchCount == 5) {
            return Prize.THIRD;
        }
        if (matchCount == 4) {
            return Prize.FOURTH;
        }
        if (matchCount == 3) {
            return Prize.FIFTH;
        }

        return Prize.NO_RANK;

    }


    private int calculateMatchCount(List<Integer> answer){
        int matchCount = 0;
        for (Integer number : answer) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    public LottoData getData(){
        return new LottoData(numbers);
    }




}
