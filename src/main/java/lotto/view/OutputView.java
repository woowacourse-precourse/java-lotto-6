package lotto.view;


import lotto.domain.WinningResult;
import lotto.domain.dto.PurchaseDto;

public interface OutputView {

    void outputPurchaseLottoList(PurchaseDto lottos);

    void outputWinningStatistics(WinningResult winningResult);
}
