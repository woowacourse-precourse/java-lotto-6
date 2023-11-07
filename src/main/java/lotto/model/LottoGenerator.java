package lotto.model;

import java.util.ArrayList;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;
import lotto.model.Lotto;

public class LottoGenerator { // 로또 생성기
	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 45;
	private final int LOTTO_SIZE = 6;
	
	private List<Integer> lotto;
	
	public List<Integer> randomNumbers(){
		return lotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
	}
}
