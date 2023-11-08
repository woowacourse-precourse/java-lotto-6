package lotto.controller.lotto;

import lotto.model.lotto.LottoWinningStatus;
import lotto.view.ProcessedValueOutputView;

public class LottoWinningStatusPrinterController {
	ProcessedValueOutputView processedValueOutputView = new ProcessedValueOutputView();
	public void printLottoWinningStatus(LottoWinningStatus lottoWinningStatus) {

		processedValueOutputView.printLottoWinningStatus(lottoWinningStatus);
	}
}
