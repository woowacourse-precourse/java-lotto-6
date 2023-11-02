package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoRankTest {

	@DisplayName("일치한 로또 번호 수와 보너스 번호 유뮤에 따른 로또 상금을 확인한다.")
	@MethodSource("createGetLottoRankTestParameter")
	@ParameterizedTest
	void checkGetLottoRankMethodReturnValue(int matchedNumCount, boolean isBonusNumber, int expect) {
		int lottoPrice = LottoRank.getLottoRank(matchedNumCount, isBonusNumber).getPrice();
		
		assertEquals(lottoPrice, expect);
	}

	static Stream<Arguments> createGetLottoRankTestParameter() {
		return Stream.of(Arguments.of(2, false, 0), Arguments.of(3, false, 5000), Arguments.of(4, false, 50000),
						Arguments.of(5, false, 1500000), Arguments.of(5, true, 30000000), Arguments.of(6, false, 2000000000));
	}
}
