package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> distinctWinningNumbers = numbers.stream().distinct().toList();

        if (numbers.size() != 6 || numbers.size() != distinctWinningNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto issue(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        return new Lotto(sortedNumbers);
    }


    @Override
    public String toString(){
        return numbers.toString();
    }
}
