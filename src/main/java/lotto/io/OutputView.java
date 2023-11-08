package lotto.io;


import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoResult;

import java.util.List;
import java.util.Map;

public interface OutputView {

    void printLottoMessage(LottoMessage lottoMessage);

    void printErrorMessage(String errorMessage);

    void printLottoCountMessage(LottoCount count);

    void printPurchaseLottos(List<Lotto> lottos);

    void printLottoStatistic(Map<LottoResult, Integer> lottoResultMap);
}
