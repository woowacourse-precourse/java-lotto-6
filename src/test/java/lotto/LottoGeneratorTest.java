package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.Controller.LottoGenerator;

public class LottoGeneratorTest {
	private LottoGenerator lottoGenerator;

	@BeforeEach
	void setUp() {
		lottoGenerator = new LottoGenerator();
	}

	@Test
	@DisplayName("서로 다른 로또 만들기")
	void testGenerateUniqueLottos() {
		int lottoCount = 10;

		List<Lotto> lottos = lottoGenerator.makeLotto(lottoCount);

		assertEquals(lottoCount, lottos.size());

		for (int i = 0; i < lottos.size(); i++) {
			for (int j = i + 1; j < lottos.size(); j++) {
				assertFalse(lottos.get(i).equals(lottos.get(j)));
			}
		}
	}
}
