package lotto.domain;



import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberCreatorTest {

	List<Integer> randomNumbers;

	@BeforeEach
	void setUp() {
		//given when
		RandomNumberCreator randomNumberCreator = new RandomNumberCreator();
		randomNumbers = randomNumberCreator.create();
	}


	@DisplayName("무작위 수의 범위를 확인")
	@Test
	void createRangeTest() {

		//then
		int expectedMaxNumber = 45;
		int expectedMinNumber = 1;

		for(int randomNumber : randomNumbers) {

			assertThat(randomNumber)
				.isLessThanOrEqualTo(expectedMaxNumber)
				.isGreaterThanOrEqualTo(expectedMinNumber);

		}

	}

	@DisplayName("무작위 수의 개수 확인")
	@Test
	void createSizeTest() {

		//when
		int actualSize = randomNumbers.size();

		//then
		int expectedSize = 6;
		assertEquals(expectedSize, actualSize);
	}
}
