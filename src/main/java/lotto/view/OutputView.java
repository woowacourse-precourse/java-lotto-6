package lotto.view;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.Rankings;

public interface OutputView {

    void outputPurchaseLottoList(List<String> purchaseLottoList);

    void outputWinningStatistics(Rankings rankings);
}
