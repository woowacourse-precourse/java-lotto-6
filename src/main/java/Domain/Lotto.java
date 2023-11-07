package Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void validateDuplicate(List<Integer> numbers) {
        if (haveDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean haveDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (compareNumberAndList(numbers.get(i), numbers, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean compareNumberAndList(int number, List<Integer> numbers, int index) {
        for(int i = 0; i < numbers.size(); i++){
            if (number == numbers.get(i) && i != index)
                return true;
        }
        return false;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
