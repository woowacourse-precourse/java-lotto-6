package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

    }

    public void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                ExceptionMessage.wrongLottoRangeException();
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            ExceptionMessage.wrongLottoDuplicateException();
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(Lotto prizeLotto){
        int matchSum = 0;
        for(int i = 0 ; i < numbers.size() ; i++){
            if(prizeLotto.numbers.contains(numbers.get(i))){
                matchSum++;
            }
        }
        return matchSum;
    }

    public boolean checkBonus(int bonus){
        return numbers.contains(bonus);
    }

}
