package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers)
            throws IllegalArgumentException
    {
        validateIs6Numbers(numbers);
        validateNoDuplicateNumber(numbers);
    }
    private void validateIs6Numbers(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개로 이루어져 있어야 해요.");
        }
    }
    private void validateNoDuplicateNumber(List<Integer> numbers)
            throws IllegalArgumentException
    {
        Set<Integer> numberKinds = new HashSet<>();
        for(int number : numbers){
            numberKinds.add(number);
        }
        if(numberKinds.size() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 있으면 안돼요.");
    }

    @Override
    public String toString() {
        StringBuilder numbers = new StringBuilder();
        numbers.append("[");
        for(int index = 0; index < this.numbers.size(); index++){
            int currentNumber = this.numbers.get(index);
            numbers.append(currentNumber);
            if(index != (this.numbers.size()-1))
                numbers.append(", ");
        }
        numbers.append("]");
        return numbers.toString();
    }
    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
