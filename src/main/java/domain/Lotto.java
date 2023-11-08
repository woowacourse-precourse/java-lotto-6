package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private Place place;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        replicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        Lotto other = (Lotto) obj;
        return other.numbers == this.numbers;
    }

    private void replicated(List<Integer> numbers){
        Set<Integer> set = numbers.stream()
                .collect(Collectors.toSet());
        if(set.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    public Place whichPlace(Lotto winningLotto, int bonusNumber){
        Set<Integer> winningNumbers = new HashSet<>(winningLotto.numbers);

        int correctNumbers = (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusOn = isBonusValidate(winningNumbers,bonusNumber);

        this.place = PlaceAndCorrectNumberMap.whichPlace(correctNumbers,bonusOn);
        return this.place;
    }
    public boolean isBonusValidate(Set<Integer> winningLotto, int bonusNumber){
        if(winningLotto.contains(bonusNumber)){
            return false;
        }
        for(int number : numbers){
            if(number == bonusNumber){
                return true;
            }
        }
        return false;
    }
    public Place getPlace(){
        return place;
    }


}
