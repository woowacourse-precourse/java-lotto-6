package lotto.domain;

import java.util.List;

public interface LottoNumberGenerator {

    List<Integer> getRandomNumber(int start, int end, int count);
}
