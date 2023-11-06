package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private static final Integer maxNumber = 45;
    private static final Integer minNumber = 1;
    private static final Integer sizeOfNumbers = 6;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != sizeOfNumbers) {
            throw new IllegalArgumentException(String.format("로또 번호의 개수는 %d이어야 합니다.", sizeOfNumbers));
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("로또 번호는 서로 중복되면 안됩니다.");
        }
        if (Collections.max(numbers) > maxNumber || Collections.min(numbers) < minNumber) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", minNumber, maxNumber));
        }
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public static Lotto generateLotto() {
        List<Integer> list = new ArrayList<>(Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, sizeOfNumbers));
        Collections.sort(list);

        return new Lotto(list);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
