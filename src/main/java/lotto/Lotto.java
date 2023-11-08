package lotto;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.InputErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException();
            }
        }
        return;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNum(){
        sortNumbers();
        System.out.println(numbers.toString());
    }

    public void sortNumbers(){
        for(int i = 0; i < numbers.size()-1; i++) {
            for(int j = 0; j < numbers.size() - i-1; j++) {
                int firstValue = (int)numbers.get(j);
                int secondValue = numbers.get(j+1);
                if(firstValue>secondValue){
                    int temp=firstValue;
                    numbers.add(j,secondValue);
                    numbers.remove(j+1);
                    numbers.add(j+1,firstValue);
                    numbers.remove(j+2);
                }
            }
        }
    }


}
