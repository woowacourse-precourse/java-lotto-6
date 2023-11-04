package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumberFactory {
	public List<Integer> lottoNumbers;
	public LottoNumberFactory() {
		this.lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		System.out.println(lottoNumbers);
	}

	public List<Lotto> makeLotto(int count){
		List<Lotto> lottoHouse = new ArrayList<>();
		for (int i = 0; i < count; i++){
			LottoNumberFactory factory = new LottoNumberFactory();
			Lotto lotto = new Lotto(factory.lottoNumbers);
			lottoHouse.add(lotto);
		}
		return lottoHouse;
	}

}
