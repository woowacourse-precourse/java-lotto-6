package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	List<Integer> lottoNumbers;
	
	public List<Integer> generateLottoTicket() {
			lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			return lottoNumbers;
	}
}
