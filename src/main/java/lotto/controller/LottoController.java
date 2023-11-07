package lotto.controller;

import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.LottoTicketList;
import lotto.domain.LottoWinningStatus;

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
	}
}
