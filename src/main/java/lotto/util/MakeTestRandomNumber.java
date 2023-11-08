package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class MakeTestRandomNumber implements RandomNum {
    private final List<Integer> randomNumber;

    public MakeTestRandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public List<Integer> getRandomNumber() {
        return randomNumber.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
