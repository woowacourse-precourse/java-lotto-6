package lotto.model.generator;

import java.util.Comparator;
import java.util.List;

public interface LottoNumberGenerator {
    List<Integer> drawLots(Comparator<Integer> order);
}
