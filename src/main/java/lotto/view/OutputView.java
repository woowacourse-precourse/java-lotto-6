package lotto.view;

import lotto.Lotto;

import java.util.List;

public interface OutputView {

    void blank();

    void myLottos(List<Lotto> Lottos, int gameCount);

    void lottoResult(List<Integer> winLottoPlaceCount, double rateMoney);
}
