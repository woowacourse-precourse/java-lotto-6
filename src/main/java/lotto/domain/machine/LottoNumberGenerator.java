package lotto.domain.machine;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {
    List<Integer> generateLottoNumbers();
}
