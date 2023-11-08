package lotto.Model.Domain;

import lotto.Exceptions.DupeNumbersException;
import lotto.Validator;

import java.util.*;

public class Lotto{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        lottoDupeCheck();
    }
    private void lottoDupeCheck() throws IllegalArgumentException{
        try{
            Set<Integer> setNumbers = new HashSet<>(numbers);
            if (setNumbers.size() != numbers.size()){
                throw new DupeNumbersException();
            }
        }catch (DupeNumbersException e){
            throw new IllegalArgumentException(e);
        }
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
