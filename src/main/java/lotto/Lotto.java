package lotto;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Winning getWinning(List<Integer> winningNumbers, int bonusNumber){
        int count = 0;
        for(Integer winningNumber : winningNumbers){
            if(numbers.contains(winningNumber)){
                count += 1;
            }
        }

        if(count == 6){ return Winning.FIRST; }
        if(count == 5){
            if(numbers.contains(bonusNumber)){
                return Winning.SECOND;
            }
            return Winning.THIRD;
        }
        if(count == 4){ return  Winning.FOURTH; }
        if(count == 3){ return Winning.FIFTH; }
        return Winning.FAIL;
    }
}
