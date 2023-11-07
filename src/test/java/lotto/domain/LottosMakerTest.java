package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Lotto;

public class LottosMakerTest {

	@DisplayName("n개의 로또가 만들어 지는지 확인")
	@ParameterizedTest
	//given
	@ValueSource(ints = {3, 4, 5})
	void makeTest(int n) {

		//when
		List<Lotto> lottos = LottosMaker.make(n);

		//then
		assertEquals(n, lottos.size());

	}
}
