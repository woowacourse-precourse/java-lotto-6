package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.config.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

	private WinningLotto winningLotto;
	private LottoPlayer lottoPlayer;
	private LottoResult lottoResult;

	@BeforeEach
	void setup() {
		winningLotto = new WinningLotto(new WinningNumbers("1,2,3,4,5,6"), new BonusNumber("7"));

		List<Lotto> lottos = new ArrayList<>();

		Lotto lotto_Rank_5 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
		Lotto lotto_losing_1 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
		Lotto lotto_losing_2 = new Lotto(List.of(39, 40, 41, 42, 43, 44));

		lottos.add(lotto_Rank_5);
		lottos.add(lotto_losing_1);
		lottos.add(lotto_losing_2);

		PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
		lottoPlayer = new LottoPlayer(lottos, purchaseAmount);
		lottoResult = new LottoResult(winningLotto, lottoPlayer);
	}

	@Test
	@DisplayName("올바르게 로또 결과를 반환하는지 테스트")
	void getLottoResult() {
		Map<LottoRank, Integer> rankResult = lottoResult.getRankResult();

		assertThat(rankResult).containsEntry(LottoRank.FIFTH, 1);
	}

	@Test
	@DisplayName("올바른 수익률을 계산하는지 테스트")
	void calculateReturnRate() {
		double returnRate = lottoResult.calculateReturnRate();

		double expectedReturnRate = 62.5;

		assertThat(returnRate).isEqualTo(expectedReturnRate);
	}
}