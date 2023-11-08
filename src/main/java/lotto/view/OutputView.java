package lotto.view;


import lotto.domain.dto.PurchaseDto;
import lotto.domain.dto.WinningResultDto;

public interface OutputView {

    void outputPurchaseLottoList(PurchaseDto purchaseDto);

    void outputWinningStatistics(WinningResultDto winningResultDto);
}
