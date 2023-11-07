package lotto.domain;

import java.util.List;

public interface LottoGenerator {
    List<Integer> create(int size);
}
