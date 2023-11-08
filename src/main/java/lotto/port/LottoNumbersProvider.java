package lotto.port;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoNumbersProvider {
    Lotto provideLottoNumbers();
}
