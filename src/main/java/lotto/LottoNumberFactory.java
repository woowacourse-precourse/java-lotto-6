package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberFactory {
	public LottoNumberFactory() {

	}

	public List<Lotto> makeLotto(int count){
		List<Lotto> lottoHouse = new ArrayList<>();
		for (int i = 0; i < count; i++){
			List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			Collections.sort(lottoNumbers);
			System.out.println(lottoNumbers);
			Lotto lotto = new Lotto(lottoNumbers);
			lottoHouse.add(lotto);
		}
		return lottoHouse;
	}

}
