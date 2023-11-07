package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.dataObjects.Bonus;
import lotto.dataObjects.Lotto;
import lotto.utils.CommonValidator;
import lotto.utils.CommonValidatorImpl;

public class BonusInputTest extends NsTest {

	@DisplayName("빈 문자열을 입력하면 예외가 발생한다.")
	@Test
	void emptyStringTest() {
		CommonValidator validator = new CommonValidatorImpl();

		assertThatThrownBy(() -> validator.validateBonusNumber(""))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 입력값이 필요합니다.");
	}

	@DisplayName("숫자를 입력하지 않으면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"\n", "\t", "-s", "우", "-1ab"})
	void digitTest(String input) {
		CommonValidator validator = new CommonValidatorImpl();

		assertThatThrownBy(() -> validator.validateBonusNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 숫자만 입력할 수 있습니다.");
	}

	@DisplayName("1보다 작은 숫자를 입력하면 예외가 발생한다.")
	@Test
	void underRangeTest() {
		CommonValidator validator = new CommonValidatorImpl();

		assertThatThrownBy(() -> validator.validateBonusNumber("0"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 1보다 작은 숫자는 입력할 수 없습니다.");
	}

	@DisplayName("45보다 큰 숫자를 입력하면 예외가 발생한다.")
	@Test
	void overRangeTest() {
		CommonValidator validator = new CommonValidatorImpl();

		assertThatThrownBy(() -> validator.validateBonusNumber("46"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 45보다 큰 숫자는 입력할 수 없습니다.");
	}

	@DisplayName("로또번호와 중복된 숫자를 입력하면 예외가 발생한다.")
	@Test
	void duplicateTest() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

		assertThatThrownBy(() -> new Bonus(1, lotto))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 로또번호와의 중복은 허용되지 않습니다.");
	}

	@Override
	protected void runMain() {
		//사용하지 않음
	}
}
