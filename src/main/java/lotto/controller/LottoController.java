package lotto.controller;

import java.util.ArrayList;
import lotto.controller.lotto.LottoBonusNumberScanController;
import lotto.controller.lotto.LottoNumberScanController;
import lotto.controller.lotto.LottoPurchaseMoneyScanController;
import lotto.controller.lotto.LottoTicketListGenerateController;
import lotto.controller.lotto.LottoTicketListPrintController;
import lotto.controller.lotto.LottoWinningStatusCheckingController;
import lotto.controller.lotto.LottoWinningStatusPrinterController;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBonus;
import lotto.domain.lotto.LottoPurchaseMoney;
import lotto.domain.lotto.LottoTicketList;
import lotto.domain.lotto.LottoWinningStatus;

public class LottoController {
	public void start() {
		LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney();
		new LottoPurchaseMoneyScanController().scanLottoPurchaseMoney(lottoPurchaseMoney);
		LottoTicketList lottoTicketList = new LottoTicketList();
		new LottoTicketListGenerateController().generateLottoTicketList(lottoPurchaseMoney, lottoTicketList);
		new LottoTicketListPrintController().printLottoTicketList(lottoTicketList);
		Lotto lotto = new Lotto(new ArrayList<>());
		new LottoNumberScanController().scanLottoNumber(lotto);
		LottoBonus lottoBonus = new LottoBonus();
		new LottoBonusNumberScanController().scanLottoBonusNumber(lotto, lottoBonus);
		LottoWinningStatus lottoWinningStatus = new LottoWinningStatus();
		new LottoWinningStatusCheckingController().checkLottoWinningStatus(lotto, lottoBonus, lottoTicketList, lottoWinningStatus);
		new LottoWinningStatusPrinterController().printLottoWinningStatus(lottoWinningStatus);
	}
}
