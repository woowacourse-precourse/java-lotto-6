package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicateNums(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void checkDuplicateNums(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public int gradingLotto(Lotto answer){
        int correct = 0;
        for (int i = 0; i < this.numbers.size(); i++){
            if(answer.numbers.contains(this.numbers.get(i))){
                correct++;
            }
        }
        return correct;
    }

    public boolean checkBonusNumber(int bonusNumber){
        return this.numbers.contains(bonusNumber);
    }
}
