package lotto.Lottery.Util;

import java.util.ArrayList;
import java.util.List;

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

        if(rangeValidate(numbers) == false)
            throw new IllegalArgumentException();

        if(duplicateValidate(numbers) == false)
            throw new IllegalArgumentException();

    }

    private boolean rangeValidate(List<Integer> numbers){
        for(Integer number: numbers){
            if(number < 0 || number > 45)
                return false;
        }
        return true;
    }

    private boolean duplicateValidate(List<Integer> numbers){
        List<Integer> tempNumbers = new ArrayList<>();
        for(Integer number: numbers){
            if(tempNumbers.contains(number))
                return false;

            tempNumbers.add(number);
        }

        return true;
    }

    public boolean bonusValidate(int bonusNumber){
        if(numbers.contains(bonusNumber))
            return false;
        return true;
    }


    public int evaluateWinnings(List<Integer> ticket){
        int winningCount = 0;

        for(int lottoNumber : ticket){
            if(numbers.contains(lottoNumber))
                winningCount += 1;
        }

        return winningCount;
    }


}
