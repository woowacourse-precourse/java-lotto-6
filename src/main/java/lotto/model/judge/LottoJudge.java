package lotto.model.judge;

import lotto.model.Lotto;
import java.util.List;

public interface LottoJudge {

    int countLottoWithMatchSize(final List<Lotto> lottos, final int matchSize);
}
