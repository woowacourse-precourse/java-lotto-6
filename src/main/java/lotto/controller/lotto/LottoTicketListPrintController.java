package lotto.controller.lotto;

import lotto.model.lotto.LottoTicketList;
import lotto.view.ProcessedValueOutputView;

public class LottoTicketListPrintController {

	ProcessedValueOutputView processedValueOutputView = new ProcessedValueOutputView();

	public void printLottoTicketList(LottoTicketList lottoTicketList) {
		Integer lottoTicketPurchaseAmount = lottoTicketList.getLottoTicketList().size();
		processedValueOutputView.printCreatedLottoTicketList(lottoTicketList.getLottoTicketList(),
			lottoTicketPurchaseAmount);
	}
}
