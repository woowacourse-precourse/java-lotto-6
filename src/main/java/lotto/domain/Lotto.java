package lotto.domain;

import lotto.common.LottoPlace;
import static lotto.common.ContstantValue.*;
import static lotto.common.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberDuplicate(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_UNIT_SIZE.getValue()) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers){
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size() != numbers.size()){
            throw new IllegalArgumentException(Duplicated_Number_ERROR.getMessage());
        }
    }

    public LottoPlace countMatchNum(Lotto lotteryTickets, int bonusNum) {
        int count =  (int) lotteryTickets.numbers.stream().filter(num -> numbers.contains(num)).count();
        boolean isBonus = isContaining(bonusNum);
        return LottoPlace.getPlaceCount(count, isBonus);
    }

    public boolean isContaining(int num) {
        return numbers.contains(num);
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
