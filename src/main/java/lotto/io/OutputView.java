package lotto.io;


import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;

import java.util.List;

public interface OutputView {

    void printLottoMessage(LottoMessage lottoMessage);

    void printErrorMessage(String errorMessage);

    void printLottoCountMessage(LottoCount count);

    void printPurchaseLottos(List<Lotto> lottos);
}
