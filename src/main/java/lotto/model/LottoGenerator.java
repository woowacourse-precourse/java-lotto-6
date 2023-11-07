package lotto.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator {
	static final int MIN_NUMBER = 1;
	static final int MAX_NUMBER = 45;
	static final int LOTTO_SIZE = 6;
	
	public List<Integer> lottoNumber(){
		return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
	}
}
