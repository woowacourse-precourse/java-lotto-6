package lotto.domain;

import java.util.List;

public interface LottoGenerator {
    int LOTTO_RANGE_MIN = 1;
    int LOTTO_RANGE_MAX = 45;
    List<Integer> create(int size);
}
