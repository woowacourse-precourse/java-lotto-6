package lotto.controller.lotto;


import static lotto.model.constant.IntegerSymbolicConstantEnum.MAX_NUMBER_FOR_LOTTO_NUMBERS;
import static lotto.model.constant.IntegerSymbolicConstantEnum.MIN_NUMBER_FOR_LOTTO_NUMBERS;
import static lotto.model.constant.IntegerSymbolicConstantEnum.SIZE_OF_TICKET;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoTicketGenerator {

	public List<Integer> generateLottoTicket() {
		return createRandomUniqueAscendingNumbersList();
	}

	private List<Integer> createRandomUniqueAscendingNumbersList() {
		Integer minNumber = MIN_NUMBER_FOR_LOTTO_NUMBERS.getValue();
		Integer maxNumber = MAX_NUMBER_FOR_LOTTO_NUMBERS.getValue();
		Integer sizeOfTicket = SIZE_OF_TICKET.getValue();
		List<Integer> randomUniqueNumberList = new ArrayList<>(Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, sizeOfTicket));
		randomUniqueNumberList.sort(Comparator.naturalOrder());
		return randomUniqueNumberList;
	}
}
