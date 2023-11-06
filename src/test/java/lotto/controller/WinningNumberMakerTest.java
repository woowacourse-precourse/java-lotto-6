package lotto.controller;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberMakerTest {

	@DisplayName("당첨 번호가 정상적으로 만들어지는지 확인")
	@Test
	void makeTest() {
		//given
		String inputNumber = "1,2,11,21,44,45";

		//when, then
		List<Integer> actualWinningNumber = WinningNumberMaker.make(inputNumber);

		//then
		List<Integer> expectedWinningNumber = asList(1, 2, 11, 21, 44, 45);

		assertThat(actualWinningNumber)
			.containsExactly(1, 2, 11, 21, 44, 45)
			.doesNotContain(0, 3, 31, 46)
			.containsExactlyElementsOf(expectedWinningNumber);

	}

	@DisplayName("구분자(,)가 아닌 다른 구분자(+)를 이용했을 때 오류가 발생하는지 확인")
	@Test
	void inputAnotherSeparator() {
		//given
		String inputNumber = "1+2+3+4+5+6";

		//when, then
		assertThatThrownBy(() -> WinningNumberMaker.make(inputNumber))
			.isInstanceOf(IllegalArgumentException.class);

	}

	@DisplayName("문자가 섞여 있을 때 오류가 발생하는지 확인")
	@Test
	void inputString() {
		//given
		String inputNumber = "1,2,3,4,5,6l";

		//when, then
		assertThatThrownBy(() -> WinningNumberMaker.make(inputNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("음수를 넣었을 때 오류가 발생하는지 확인")
	@Test
	void inputMinus() {
		//given
		String inputNumber = "1,2,3,4,5,-6";

		//when, then
		assertThatThrownBy(() -> WinningNumberMaker.make(inputNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("범위 밖의 숫자를 넣었을 때 오류가 발생하는지 확인")
	@Test
	void inputOutOfRange() {
		//given
		String inputNumber = "1,2,3,4,5,46";

		//when, then
		assertThatThrownBy(() -> WinningNumberMaker.make(inputNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 번호의 개수가 6개가 넘어가면 오류가 발생하는지 확인")
	@Test
	void createByOverSize() {
		//given
		String inputNumber = "1,2,3,4,5,6,7";

		//when, then
		assertThatThrownBy(() -> WinningNumberMaker.make(inputNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("음수를 넣었을 때 오류가 발생하는지 확인")
	@Test
	void createByDuplicatedNumber() {
		//given
		String inputNumber = "1,2,3,4,5,5";

		//when, then
		assertThatThrownBy(() -> WinningNumberMaker.make(inputNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 당첨 번호와 중복될 경우 오류가 발생하는지 확인")
	@Test
	void bonusNumberOverlapWinningNumber(){
		//given
		String inputWinningNumber = "1,2,3,4,5,6";
		WinningNumberMaker.make(inputWinningNumber);
		String inputBonusNumber = "5";

		//when, then
		assertThatThrownBy(() -> WinningNumberMaker.makeBonusNumber(inputBonusNumber))
			.isInstanceOf(IllegalArgumentException.class);

	}

}
