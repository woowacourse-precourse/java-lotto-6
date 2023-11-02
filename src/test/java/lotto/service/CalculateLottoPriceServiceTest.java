package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.LottoRank;
import lotto.domain.Money;

public class CalculateLottoPriceServiceTest {

	private final CalculateLottoPriceService service = new CalculateLottoPriceService();

	@DisplayName("총수익률을 확인한다.")
	@MethodSource("creategetTotalReturnMethodParameter")
	@ParameterizedTest
	void checkGetTotalReturn(List<LottoRank> lottoRanks, Money money, double expect) {
		double totalReturn = service.getTotalReturn(lottoRanks, money);
		System.out.println(totalReturn);
		assertEquals(totalReturn, expect);
	}

	@DisplayName("로또상금의 합계를 확인한다.")
	@MethodSource("createGetPriceSumMethodParameter")
	@ParameterizedTest
	void CheckGetPriceSum(List<LottoRank> lottoRanks, int expect) {
		int priceSum = service.getPriceSum(lottoRanks);

		assertEquals(priceSum, expect);
	}

	static Stream<Arguments> creategetTotalReturnMethodParameter() {
		return Stream.of(Arguments.of(List.of(LottoRank.FIFTH), new Money(8000), 62.5));
	}

	static Stream<Arguments> createGetPriceSumMethodParameter() {
		return Stream.of(Arguments.of(List.of(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.FOURTH), 105000));
	}
}
