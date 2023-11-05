package lotto.utils.generator;

import java.util.List;
import lotto.domain.Lotto;

public interface NumbersGenerator {
    List<Lotto> generateLottos(int count);
}
