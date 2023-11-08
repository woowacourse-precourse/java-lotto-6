package lotto.view;


import lotto.domain.entity.WinningResult;
import lotto.domain.dto.PurchaseDto;

public interface OutputView {

    void outputPurchaseLottoList(PurchaseDto lottos);

    void outputWinningStatistics(WinningResult winningResult);
}
