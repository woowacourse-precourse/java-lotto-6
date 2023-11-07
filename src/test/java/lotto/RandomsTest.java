package lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsTest {
	int minNumber;
	int maxNumber;
	int count;

	@BeforeEach
	void setUp() {
		minNumber = 1;
		maxNumber = 45;
		count = 6;
	}

	@Test
	void pickUniqueNumbersInRange메서드가_주어진범위내에서_주어진_크기의수를_반환한다() {
		List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, count);

		assertThat(randomNumbers).allMatch(number -> number >= minNumber && number <= maxNumber);
		assertThat(randomNumbers.size()).isEqualTo(count);
	}

	@Test
	void pickUniqueNumbersInRange메서드가_주어진범위내에서_중복되지_않은수를_반환한다() {
		List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, count);

		Long nonDuplicatedNumbersCount = randomNumbers.stream().distinct().count();
		assertThat(nonDuplicatedNumbersCount).isEqualTo(count);
	}
}
