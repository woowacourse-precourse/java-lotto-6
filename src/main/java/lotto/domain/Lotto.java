package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.constant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != constant.WITHBONUSNUMBERSIZE) {
            throw new IllegalArgumentException(NUMBERSIZE.getMessage());
        }
    }

    private void validateInRange(List<Integer> numbers){
        for (int number : numbers) {
            if(number < constant.MINLOTTONUMBER || number > constant.MAXLOTTONUMBER){
                throw new IllegalArgumentException(NUMBERINRANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if(noDuplicateNumbers.size() != constant.WITHBONUSNUMBERSIZE){
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
        return numbers.get(constant.WITHBONUSNUMBERSIZE);
    }

    public List<Integer> getLottoNumbersWithoutBonusNumber(){
        int withoutBonusNumber = numbers.size() - 1;
        List<Integer> LottoNumbersWithoutBonusNumber = new ArrayList<>(numbers.subList(0, withoutBonusNumber));
        return LottoNumbersWithoutBonusNumber;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
