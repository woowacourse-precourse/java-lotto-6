package lotto;

import java.util.List;
import lotto.ui.Output;
import lotto.ui.SystemMessage;

public class LottoResults {

	private List<LottoResult> lottoResults;

	public static LottoResults of(List<LottoResult> lottoResults) {
		return new LottoResults(lottoResults);
	}

	private LottoResults(List<LottoResult> lottoResults) {
		this.lottoResults = lottoResults;
	}


	public Integer calculateRevenue() {
		Integer revenue = 0;
		revenue += calculateResult(LottoResult.THREE, lottoResults);
		revenue += calculateResult(LottoResult.FOUR, lottoResults);
		revenue += calculateResult(LottoResult.FIVE, lottoResults);
		revenue += calculateResult(LottoResult.FIVE_PLUS_BONUS, lottoResults);
		revenue += calculateResult(LottoResult.SIX, lottoResults);
		return revenue;
	}

	private Integer calculateResult(LottoResult lottoResult, List<LottoResult> lottoResults) {
		Long count = lottoResults
				.stream()
				.filter(lottoResult::equals)
				.count();
		Output.output(() ->
				SystemMessage.lottoResults(
						lottoResult.getMatchCondition(),
						lottoResult.getPrize(),
						count));
		return lottoResult.getPrize() * count.intValue();
	}
}
