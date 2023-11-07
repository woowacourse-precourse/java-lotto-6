package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        arrangeNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 한 로또에는 6개의 수가 있어야 합니다.");
        }
        for (int number : numbers) {
            if (!isInRange(number)) {
                throw new IllegalArgumentException("[ERROR] 로또의 수는 1 ~ 45의 범위에 있어야 합니다.");
            }
        }
        if (existDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또의 수에는 중복이 없어야 합니다.");
        }
    }
    
    private boolean isInRange(int number) {
        return (number >= 1 && number <= 45); 
    }
    
    private boolean existDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<Integer>(numbers);
        return numberSet.size() < numbers.size();
    }
    
    private void arrangeNumbers() {
        Collections.sort(numbers);
    }
    
    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
