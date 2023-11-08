package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.type.LottoResult;

public class LottoPaperTest {

	@Test
	@DisplayName("LottoPaper 생성자 테스트")
	public void testLottoPaperCreation() {
		// Given
		Integer money = 5000;

		// When
		LottoPaper lottoPaper = new LottoPaper(money);
		List<Lotto> lottos = lottoPaper.getLottos();

		// Then
		assertEquals(money / 1000, lottos.size());
	}

	@Test
	@DisplayName("LottoPaper 생성자 테스트 - 1000원 단위가 아닌 금액")
	public void testSetAndGetResults() {
		// Given
		LottoPaper lottoPaper = new LottoPaper(5000);
		Map<LottoResult, Integer> results = mock(Map.class);

		// When
		lottoPaper.setResults(results);
		Map<LottoResult, Integer> retrievedResults = lottoPaper.getResults();

		// Then
		assertSame(results, retrievedResults);
	}
}
