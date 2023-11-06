package lotto.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private List<Integer> numbers;

    public LottoGenerator() {
        this.numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList())
        ;
    }

    public void numberShuffle() {
        Collections.shuffle(numbers);
    }

    public List<Integer> getLottoNumber() {
        numberShuffle();
        List<Integer> selectedNumbers = numbers.subList(0, 6);
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }
}
