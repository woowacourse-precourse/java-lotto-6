package LottoRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lottoBuy.LottoPurchase;

public class LottoInput {
	private List<Integer> lottoNumberList;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int CNT_LOTTO_NUMBER = 6;

	public LottoInput() {

	}

	public List<Integer> setRandomNumber() {
		lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
		List<Integer> lottoTicketList = new ArrayList<>(lottoNumberList);
		Collections.sort(lottoTicketList);

		return lottoTicketList;

	}

}
