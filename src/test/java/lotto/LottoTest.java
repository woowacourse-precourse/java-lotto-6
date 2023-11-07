package lotto;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.Prize;

class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 번호 비교 기능 확인")
	@Test
	void matchTest() {
		//given
		List<Integer> numbers = asList(1,2,3,4,5,6);
		Lotto lotto = new Lotto(numbers);

		List<Integer> winningNumber = asList(1,2,3,7,8,9);
		int bonusNumber = 45;

		//when
		String actualResult = lotto.match(winningNumber, bonusNumber);

		//then
		String expectedResult = Prize.FIFTH.getHitResult();
		assertEquals(expectedResult, actualResult);

	}

	@DisplayName("보너스 번호 일치 확인")
	@Test
	void bonusMatchTest() {
		//given
		List<Integer> numbers = asList(1,2,3,4,5,6);
		Lotto testLotto = new Lotto(numbers);

		List<Integer> winningNumber = asList(1,2,3,4,5,45);
		int bonusNumber = 6;

		//when
		String actualResult = testLotto.match(winningNumber, bonusNumber);

		//then
		String expectedResult = Prize.SECOND.getHitResult();
		assertEquals(expectedResult, actualResult);

	}

}