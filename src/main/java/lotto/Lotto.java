package lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE=6;
    private static final int NUMBER_LOW_BOUND=1;
    private static final int NUMBER_HIGH_BOUND=45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        if (isDuplicated(numbers)){
            throw new IllegalArgumentException();
        }

        if (isOutOfRange(numbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers){
        int uniqueSize=numbers.stream().distinct().toList().size();

        return uniqueSize!=LOTTO_SIZE;
    }

    public List<Integer> getSortingNumbers(){
        return numbers.stream().sorted().toList();
    }

    private boolean isOutOfRange(List<Integer> numbers){
        List<Integer> outOfRangeNumbers=numbers.stream()
                .filter((number)->number<NUMBER_LOW_BOUND || number>NUMBER_HIGH_BOUND)
                .toList();

        return !outOfRangeNumbers.isEmpty();
    }

    public boolean isContains(int number){
        return numbers.contains(number);
    }
}
