package lotto.controller.lotto;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoBonus;
import lotto.model.lotto.LottoPurchaseMoney;
import lotto.model.lotto.LottoTicketList;
import lotto.model.lotto.LottoWinningStatus;

public class LottoController {
	public void start() {
		LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney();
		new LottoPurchaseMoneyScanController().scanLottoPurchaseMoney(lottoPurchaseMoney);
		new LottoPurchaseMoneyPrintController().printLottoPurchaseMoney(lottoPurchaseMoney);
		LottoTicketList lottoTicketList = new LottoTicketList();
		new LottoTicketListGenerateController().generateLottoTicketList(lottoPurchaseMoney, lottoTicketList);
		new LottoTicketListPrintController().printLottoTicketList(lottoTicketList);
		Lotto lotto = new LottoNumberScanController().scanLottoNumber();
		LottoBonus lottoBonus = new LottoBonus();
		new LottoBonusNumberScanController().scanLottoBonusNumber(lotto, lottoBonus);
		LottoWinningStatus lottoWinningStatus = new LottoWinningStatus();
		new LottoWinningStatusCheckingController().checkLottoWinningStatus(lotto, lottoBonus, lottoTicketList, lottoWinningStatus);
		new LottoWinningStatusPrinterController().printLottoWinningStatus(lottoWinningStatus);
	}
}
