package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.dataObjects.Lotto;
import lotto.utils.CommonValidator;
import lotto.utils.CommonValidatorImpl;

public class WinningInputTest extends NsTest {

	@DisplayName("빈 문자열을 입력하면 예외가 발생한다.")
	@Test
	void emptyStringTest() {
		CommonValidator validator = new CommonValidatorImpl();
		StringTokenizer numberSplitter = new StringTokenizer(",", ",");
		List<Integer> dummyStructure = new ArrayList<>();

		assertThatThrownBy(() -> validator.validateWinningNumber(numberSplitter, dummyStructure))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 입력값이 필요합니다.");
	}

	@DisplayName("숫자를 입력하지 않으면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"\n", "1,\t", "-s", "우", "-1ab"})
	void digitTest(String input) {
		CommonValidator validator = new CommonValidatorImpl();
		StringTokenizer numberSplitter = new StringTokenizer(input, ",");
		List<Integer> dummyStructure = new ArrayList<>();

		assertThatThrownBy(() -> validator.validateWinningNumber(numberSplitter, dummyStructure))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 숫자만 입력할 수 있습니다.");
	}

	@DisplayName("1보다 작은 숫자를 입력하면 예외가 발생한다.")
	@Test
	void underRangeTest() {
		CommonValidator validator = new CommonValidatorImpl();
		StringTokenizer numberSplitter = new StringTokenizer("0", ",");
		List<Integer> dummyStructure = new ArrayList<>();

		assertThatThrownBy(() -> validator.validateWinningNumber(numberSplitter, dummyStructure))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 1보다 작은 숫자는 입력할 수 없습니다.");
	}

	@DisplayName("45보다 큰 숫자를 입력하면 예외가 발생한다.")
	@Test
	void overRangeTest() {
		CommonValidator validator = new CommonValidatorImpl();
		StringTokenizer numberSplitter = new StringTokenizer("46", ",");
		List<Integer> dummyStructure = new ArrayList<>();

		assertThatThrownBy(() -> validator.validateWinningNumber(numberSplitter, dummyStructure))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 45보다 큰 숫자는 입력할 수 없습니다.");
	}

	@DisplayName("6개보다 적은 갯수를 입력하면 예외가 발생한다.")
	@Test
	void numberTest() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 쉼표로 구분된 6개의 숫자를 입력해야 합니다.");
	}


	@Override
	protected void runMain() {
		//사용하지 않음
	}
}
