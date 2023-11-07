package lotto.domain;

import java.util.List;
import lotto.utils.Generator;

public class LottoSeller {

    public Lotto generateLotto(int start, int end, int count) {
        List<Integer> numbers = Generator.generateNumbers(start, end, count);
        return new Lotto(numbers);
    }

}
