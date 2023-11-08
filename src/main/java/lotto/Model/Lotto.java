package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        if(isNumbersOutOfRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~45 사이어야 합니다.");
        }
        if(isNumbersDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 서로 다른 숫자여야 합니다.");
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
    private boolean isNumberOutOfRange(Integer number){
        return number < 1  || 45 < number;
    }

    private boolean isNumbersDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumbersOutOfRange(List<Integer> numbers){
        for(Integer number:numbers){
            if(isNumberOutOfRange(number))
                return true;
        }
        return false;
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
