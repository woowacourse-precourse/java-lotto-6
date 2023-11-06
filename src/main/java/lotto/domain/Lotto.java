package lotto.domain;

import static lotto.etc.ErrorConstant.BONUS_ERROR;
import static lotto.etc.ErrorConstant.DUPLICATE_ERROR;
import static lotto.etc.ErrorConstant.NOT_SIX_ERROR;
import static lotto.etc.Validate.checkOneAndFortyFive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ArrayList<Integer> tempNumbers = new ArrayList<>(numbers);
        Collections.sort(tempNumbers);
        this.numbers = tempNumbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_ERROR.toString());
        }

        if(new HashSet<>(numbers).size() != 6){
            throw new IllegalArgumentException(DUPLICATE_ERROR.toString());
        }

        for(Integer number : numbers){
            checkOneAndFortyFive(number);
        }
    }

    public void duplicateBonusNumber(int bonus){
        checkOneAndFortyFive(bonus);
        Set<Integer> userSet = new HashSet<>(numbers);
        userSet.add(bonus);
        if(userSet.size() == 6){
            throw new IllegalArgumentException(BONUS_ERROR.toString());
        }
    }
}
