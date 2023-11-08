package lotto.controller.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.START_OF_COUNT;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;

public class LottoSameNumberCounter {

	public int countLottoSameNumber(Lotto lotto, LottoTicket lottoTicket) {
		List<Integer> lottoNumberList = lotto.getNumbers();
		List<Integer> lottoTicketNumberList = lottoTicket.getTicketNumbers();
		int counterForSameNumber = START_OF_COUNT.getValue();
		for (Integer lottoTicketNumber : lottoTicketNumberList) {
			counterForSameNumber += checkIfContainsNumber(lottoNumberList, lottoTicketNumber);
		}
		return counterForSameNumber;
	}

	private int checkIfContainsNumber(List<Integer> lottoNumberList, Integer lottoTicketNumber) {
		if (lottoNumberList.contains(lottoTicketNumber)) {
			return 1;
		}
		return 0;
	}
}
