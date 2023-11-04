package lotto.util.generator;

import java.util.List;
import lotto.domain.Lotto;

public interface Generator {
    List<Lotto> generate(int lottoCount);
}
