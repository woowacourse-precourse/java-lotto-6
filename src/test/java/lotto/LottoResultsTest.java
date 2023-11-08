package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

	@DisplayName("수익 계산 테스트")
	@Test
	void calculateRate() {
		LottoResults lottoResults = LottoResults.of(
				List.of(
						LottoResult.THREE,
						LottoResult.FOUR,
						LottoResult.FIVE,
						LottoResult.FIVE_PLUS_BONUS,
						LottoResult.SIX
				));
		Integer revenue = lottoResults.calculateRevenue();
		Integer expectedRevenue = LottoResult.THREE.getPrize() +
				LottoResult.FOUR.getPrize() +
				LottoResult.FIVE.getPrize() +
				LottoResult.FIVE_PLUS_BONUS.getPrize() +
				LottoResult.SIX.getPrize();
		assertEquals(expectedRevenue, revenue);
	}

}