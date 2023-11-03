package lotto.view.output;

import lotto.model.dto.LottoResponse;
import java.util.List;

public interface OutputView {

    void askInvestMoney();
    void printBoughtLottoSize(final int size);
    void printEachLottoNumbers(final List<LottoResponse> lottoResponses);
}
