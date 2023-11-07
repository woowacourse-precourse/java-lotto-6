package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.Error.INVALID_WIN_NUMBER.getMessage());
        }
        HashSet<Integer> overlapCheck = new HashSet<>(numbers);
        if (numbers.size() != overlapCheck.size()){
            throw new IllegalArgumentException(Message.Error.OVERLAP_INPUT.getMessage());
        }
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    public int lottoNumbersContains(List<Integer> winningNumbers){
        int equalNumbers = 0;
        for (Integer winningNumber : winningNumbers){
            if (numbers.contains(winningNumber)){
                equalNumbers++;
            }
        }
        return equalNumbers;
    }

    public int bonusNumberContains(int equalNumbers, int bonusNumber){
        for (Integer number : numbers){
            if (number == bonusNumber){
                equalNumbers++;
                return equalNumbers;
            }
        }
        return equalNumbers;
    }
}
