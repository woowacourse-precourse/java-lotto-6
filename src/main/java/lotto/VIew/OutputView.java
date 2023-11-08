package lotto.VIew;

import lotto.Domain.LottoGroup;
import lotto.Domain.LottoResult.LottoResult;

public interface OutputView {

    void printLottoCount(int lottoCount);

    void printOrderedLottos(LottoGroup lottoGroup);

    void printLottoResult(LottoResult lottoResult);

    void printProfitRate(float profitRate);
}
