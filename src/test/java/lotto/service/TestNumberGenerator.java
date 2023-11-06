package lotto.service;

import java.util.List;
import lotto.domain.LottoNumberGenerator;

public class TestNumberGenerator implements LottoNumberGenerator {

    public List<Integer> getRandomNumber(int start, int end, int count) {
        return List.of(1, 3, 5, 7, 9, 11);
    }
}
