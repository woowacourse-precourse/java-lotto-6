package lotto;

import static lotto.ErrorMessage.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERSIZE.getMessage());
        }
    }

    private void validateInRange(List<Integer> numbers){
        for (int number : numbers) {
            if(number < 1 || number > 45){
                throw new IllegalArgumentException(NUMBERINRANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if(noDuplicateNumbers.size() != 6){
            throw new IllegalArgumentException(NUMBERDUPLICATE.getMessage());
        }
    }

    public void addBonusNumber(int bonusNumber){
        numbers.add(bonusNumber);
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    public int getBonusNumber(){
        return numbers.get(6);
    }

    public List<Integer> getLottoNumbersWithoutBonusNumber(){
        int lastIndex = numbers.size() - 1;
        List<Integer> LottoNumbersWithoutBonusNumber = new ArrayList<>(numbers.subList(0, lastIndex));
        return LottoNumbersWithoutBonusNumber;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
