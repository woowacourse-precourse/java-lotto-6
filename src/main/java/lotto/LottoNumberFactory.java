package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberFactory {

	public static List<Lotto> makeLotto(int count){
		List<Lotto> lottoHouse = new ArrayList<>();
		for (int i = 0; i < count; i++){
			List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			Collections.sort(lottoNumbers);
			Lotto lotto = new Lotto(lottoNumbers);
			lottoHouse.add(lotto);
		}
		return lottoHouse;
	}

}
