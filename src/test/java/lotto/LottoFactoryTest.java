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

	@Test
	void checkMakeLottoFunctionDuplicate() {
		List<Lotto> testLotto = LottoNumberFactory.makeLotto(10);

		for (Lotto lotto : testLotto) {
			List<Integer> numbers = lotto.getNumbers();
			Set<Integer> numberSet = new HashSet<>(numbers);
			assertEquals(numbers.size(), numberSet.size());
		}
	}

	@Test
	void checkMakeLottoFunctionLottoSize(){
		List<Lotto> testLotto = LottoNumberFactory.makeLotto(10);
		for (Lotto lotto : testLotto){
			List<Integer> numbers = lotto.getNumbers();
			assertEquals(numbers.size(), 6);
		}
	}
}