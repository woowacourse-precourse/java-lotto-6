package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumbers {

	public LottoNumbers() {
	}

	private static final int CNT_LOTTO_NUMBER = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private static List<Integer> lottoNumbers;

	public List<Integer> setRandomNumbers() {
		lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
		List<Integer> lottoTicketNumberList = new ArrayList<>(lottoNumbers);
		Collections.sort(lottoTicketNumberList);
		return lottoTicketNumberList;
	}

}