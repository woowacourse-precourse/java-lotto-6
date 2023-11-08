package lotto.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    int bonusNumber;

    public WinningLotto(List<Integer> numbers, int number) {
        this.numbers = numbers;
        this.bonusNumber = number;
    }

    public List<Integer> compareLottos(List<Lotto> lottos) {
        List<Integer> resultNumber = new ArrayList<>();
        for (Lotto lotto : lottos) {
            resultNumber.add(lotto.checkNumber(numbers));
        }
        return resultNumber;
    }
}
