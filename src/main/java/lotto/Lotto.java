package lotto;

import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumbers() {
        System.out.println(this.numbers);
    }

    public int getSameNumberCount(List<Integer> otherList) {
        Stream<Integer> allNumbers = Stream.concat(this.numbers.stream(), otherList.stream());
        int sameCount = LottoPrinciples.MAX_ALL_NUMBER.getNumber();
        sameCount -= (int) allNumbers.distinct().count();
        return sameCount;
    }
}
