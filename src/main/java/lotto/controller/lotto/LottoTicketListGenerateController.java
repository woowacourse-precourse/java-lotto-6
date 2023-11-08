package lotto.controller.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.END_OF_COUNT;
import static lotto.model.constant.IntegerSymbolicConstantEnum.MONEY_UNIT;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.LottoPurchaseMoney;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.LottoTicketList;

public class LottoTicketListGenerateController {
	public void generateLottoTicketList(LottoPurchaseMoney lottoPurchaseMoney, LottoTicketList lottoTicketList) {
		Integer countForGeneratingLottoTickets = lottoPurchaseMoney.getLottoPurchaseMoney() / MONEY_UNIT.getValue();
		lottoTicketList.setLottoTicketList(createLottoTicketList(countForGeneratingLottoTickets));
	}

	private List<LottoTicket> createLottoTicketList(Integer countForGeneratingLottoTickets) {
		List<LottoTicket> lottoTicketList = new ArrayList<>();
		LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
		int count = countForGeneratingLottoTickets.intValue();
		while (END_OF_COUNT.getValue() < count--){
			LottoTicket lottoTicket = new LottoTicket();
			lottoTicket.setTicketNumbers(lottoTicketGenerator.generateLottoTicket());
			lottoTicketList.add(lottoTicket);
		}
		return lottoTicketList;
	}
}
