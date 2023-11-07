package lotto.utils.generator;

import java.util.List;
import lotto.domain.Lotto;

public interface LottsGenerator {

    List<Lotto> generateLottos(int purchaseAmount);
}
