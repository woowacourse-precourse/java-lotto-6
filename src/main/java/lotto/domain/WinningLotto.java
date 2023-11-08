package lotto.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<Integer> numbers;
    int bonusNumber;

    public WinningLotto(List<Integer> numbers, int number) {
        this.numbers = numbers;
        this.bonusNumber = number;
    }

    public Map<Integer, Integer> compareLottos(List<Lotto> lottos) {
        List<Integer> resultNumber = new ArrayList<>();
        for (Lotto lotto : lottos) {
            resultNumber.add(lotto.checkNumber(numbers, bonusNumber));
        }
        return changeNumbersMap(resultNumber);
    }

    public Map<Integer, Integer> changeNumbersMap(List<Integer> resultNumber) {
        List<Integer> excludeValues = Arrays.asList(0, 1, 2);
        Map<Integer, Integer> countByNumberAsInteger = resultNumber.stream()
                .filter(number -> !excludeValues.contains(number))
                .collect(Collectors.groupingBy(
                        number -> number,
                        Collectors.summingInt(e -> 1)
                ));

        for (int key = 3; key <= 7; key++) {
            countByNumberAsInteger.putIfAbsent(key, 0);
        }

        return countByNumberAsInteger;
    }

}


