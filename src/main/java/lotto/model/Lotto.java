package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicateNumber(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumber(){
      return numbers;
    }

    public Integer compareLotto(Lotto winningLotto, Integer bonusNumber) {
        int equalsNumber = Math.toIntExact(numbers.stream()
                .filter(winningLotto.getLottoNumber()::contains)
                .count());

        if(equalsNumber == 5 && compareBonusNumber(bonusNumber)){
            equalsNumber = equalsNumber + 2;
        }
        return equalsNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);

        if(numberSet.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    private boolean compareBonusNumber(Integer bonusNumber){
        return numbers.contains(bonusNumber);
    }

}
