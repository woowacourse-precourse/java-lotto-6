package lotto.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lotto.constant.LottoConstant;

class LottoGeneratorTest {
	@Test
	void 로또번호생성_개수_여섯개() {
		// When
		List<Integer> numbers = LottoGenerator.getLottoNumbers();

		// Then
		assertEquals(LottoConstant.PICK_COUNT.getValue(), numbers.size());
	}

	@Test
	void 로또번호생성_중복체크() {
		// When
		List<Integer> numbers = LottoGenerator.getLottoNumbers();

		// Then
		Set<Integer> numbersSet = new HashSet<>(numbers);
		assertEquals(numbers.size(), numbersSet.size());
	}

	@Test
	void 로또번호생성_범위체크() {
		// When
		List<Integer> numbers = LottoGenerator.getLottoNumbers();

		// Then
		assertTrue(numbers.stream().allMatch(number ->
			number >= LottoConstant.MIN_LOTTO_NUMBER.getValue() &&
				number <= LottoConstant.MAX_LOTTO_NUMBER.getValue()
		));
	}
}