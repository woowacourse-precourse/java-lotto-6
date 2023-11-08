package lotto.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    public Map<Integer, String> compareLottos(List<Lotto> lottos) {
        List<Integer> resultNumber = new ArrayList<>();
        for (Lotto lotto : lottos) {
            resultNumber.add(lotto.checkNumber(numbers));
        }
        return changeNumbersMap(resultNumber);
    }

    public Map<Integer,String> changeNumbersMap (List<Integer> resultNumber){
        Map<Integer, String> countByNumberAsString =
                resultNumber.stream().filter(number -> number != 0).
                        collect(Collectors.groupingBy(number -> number,
                                Collectors.collectingAndThen(Collectors.counting(), count -> count.toString())
                        ));
        return countByNumberAsString;
    }
}
