package lotto.view;

import lotto.Lotto;
import lotto.message.OutputMessage;

import java.util.List;

public interface OutputView {

    public void blank();

    public void myLottos(List<Lotto> Lottos, int gameCount);
    public void lottoResult(List<Integer> winLottoPlaceCount,double rateMoney);
}
