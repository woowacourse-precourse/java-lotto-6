package lotto.domain;

import java.util.List;

public class UserLottos {
	private List<Integer> lottoNumbers;
	
	public UserLottos(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}
	public List<Integer> getLottoNumbers(){
		return lottoNumbers;
	}
}
