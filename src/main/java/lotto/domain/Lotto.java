package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConfig;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoConfig.*;

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

    // TODO: 추가 기능 구현
    
    private static int getLottoCount (int payment) {
        return payment / LottoConfig.UNIT_PRICE.getValue();
    }

}
