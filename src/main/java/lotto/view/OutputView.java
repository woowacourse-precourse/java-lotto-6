package lotto.view;


import lotto.domain.dto.WinningResultDto;
import lotto.domain.entity.WinningResult;
import lotto.domain.dto.PurchaseDto;

public interface OutputView {

    void outputPurchaseLottoList(PurchaseDto purchaseDto);

    void outputWinningStatistics(WinningResultDto winningResultDto);
}
