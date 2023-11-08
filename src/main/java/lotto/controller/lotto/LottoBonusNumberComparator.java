package lotto.controller.lotto;

import lotto.model.lotto.LottoBonus;
import lotto.model.lotto.LottoTicket;

public class LottoBonusNumberComparator {

	public Boolean compareLottoBonusNumber(LottoBonus lottoBonus, LottoTicket lottoTicket) {
		if (lottoTicket.getTicketNumbers().contains(lottoBonus.getLottoBonusNumber())) {
			return true;
		}
		return false;
	}
}
