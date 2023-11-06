package lotto.dto.response;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.UserLotto;

public class LottoCollection {

	private List<LottoNumber> lottoCollection = new ArrayList<>();

	private Integer lottoCount;

	public List<LottoNumber> getLottoCollection() {
		return lottoCollection;
	}

	public void addLottoCollection(LottoNumber lottoNumber) {
		this.lottoCollection.add(lottoNumber);
	}

	public void setLottoCount(Integer lottoCount) {
		this.lottoCount = lottoCount;
	}

	public Integer getLottoCount() {
		return lottoCount;
	}
}
