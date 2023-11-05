package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {
	@Test
	void checkMakeLottoFunctionCount(){
		List<Lotto> testLotto = LottoNumberFactory.makeLotto(10);
		assertEquals(testLotto.size(), 10);
	}
}