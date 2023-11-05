package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.domain.Money;
import lotto.model.domain.Revenue;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.result.LottoResult;

public interface LottoGameUI {
    Money getMoney();

    void printPurchasedLottos(List<Lotto> lottosDTO);

    List<Integer> getAnswerNumber();

    Integer getBonusNumber();

    void printResult(List<Map.Entry<LottoResult, Integer>> results);

    void printRevenue(Revenue revenue);
}
