package lotto.domain;

import static lotto.etc.ErrorConstant.BETWEEN_ONE_AND_FORTY_FIVE_ERROR;
import static lotto.etc.ErrorConstant.BONUS_ERROR;
import static lotto.etc.ErrorConstant.DUPLICATE_ERROR;
import static lotto.etc.ErrorConstant.NOT_SIX_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(NOT_SIX_ERROR);
            throw new IllegalArgumentException();
        }

        if(new HashSet<>(numbers).size() != 6){
            System.out.println(DUPLICATE_ERROR);
            throw new IllegalArgumentException();
        }

        for(Integer number : numbers){
            if (!(number >= 1 && number <= 45)){
                System.out.println(BETWEEN_ONE_AND_FORTY_FIVE_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }

    public void duplicateBonusNumber(int bonus){
        Set<Integer> userSet = new HashSet<>(numbers);
        userSet.add(bonus);
        if(userSet.size() == 6){
            System.out.println(BONUS_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
