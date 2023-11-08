package lotto.domain;

import java.util.List;
import java.util.Map;

import lotto.type.LottoResult;

public class LottoPaper {
	private List<Lotto> lottos;
	private Map<LottoResult, Integer> results;

	public LottoPaper(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public void setResults(Map<LottoResult, Integer> results) {
		this.results = results;
	}
}
