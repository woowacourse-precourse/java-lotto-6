package lotto.Model.Domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    @Override
    public String toString(){
        return numbers.toString();
    }
    public int compareWithWinningNumber(List<Integer> winningNumber){
        int hitAmount = 0, iterateLotto = 0, iterateWinningNumber = 0;
        while (iterateLotto < numbers.size() && iterateWinningNumber < winningNumber.size()){
            if (numbers.get(iterateLotto) < winningNumber.get(iterateWinningNumber)){
                iterateLotto++;
                continue;
            }if (numbers.get(iterateLotto) > winningNumber.get(iterateWinningNumber)){
                iterateWinningNumber++;
                continue;
            }
            hitAmount++;
            iterateLotto++;
        }
        return hitAmount;
    }
    public Boolean compareWithWinningBonusNumber(int winningBonusNumber){
        if (numbers.contains(winningBonusNumber)){
            return true;
        }
        return false;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
