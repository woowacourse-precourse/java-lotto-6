package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import net.bytebuddy.implementation.bind.annotation.Argument;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.dataObjects.Money;
import lotto.utils.CommonValidator;
import lotto.utils.CommonValidatorImpl;

public class PurchaseInputTest extends NsTest {

	@DisplayName("빈 문자열을 입력하면 예외가 발생한다.")
	@Test
	void emptyStringTest() {
		CommonValidator validator = new CommonValidatorImpl();

		assertThatThrownBy(() -> validator.validatePrice(""))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 입력값이 필요합니다.");
	}

	@DisplayName("숫자를 입력하지 않으면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"\n", "\t", "-s", "우", "-1ab"})
	void digitTest(String input) {
		CommonValidator validator = new CommonValidatorImpl();

		assertThatThrownBy(() -> validator.validatePrice(input))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 숫자만 입력할 수 있습니다.");
	}

	@DisplayName("int 범위가 아닌 금액을 입력하면 예외가 발생한다.")
	@Test
	void rangeTest() {
		CommonValidator validator = new CommonValidatorImpl();

		assertThatThrownBy(() -> validator.validatePrice("-1242352346366236"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 범위를 초과한 금액입니다.");
	}

	@DisplayName("자연수를 입력하지 않으면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"0", "-1"})
	void naturalTest(String input) {
		CommonValidator validator = new CommonValidatorImpl();

		assertThatThrownBy(() -> validator.validatePrice(input))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 1보다 작은 숫자는 입력할 수 없습니다.");
	}

	@DisplayName("1000원보다 적은 금액을 입력하면 예외가 발생한다.")
	@Test
	void minimumTest() {
		assertThatThrownBy(() -> new Money(999))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 1000원 이상의 금액만 입력할 수 있습니다.");
	}

	@DisplayName("1000원으로 나누어 떨이지지 않는 금액을 입력하면 예외가 발생한다.")
	@Test
	void moneyUnitTest() {
		assertThatThrownBy(() -> new Money(12345))
			.isInstanceOf(IllegalArgumentException.class);
		assertThat(output()).isEqualTo("[ERROR] 1000원 단위부터 입력할 수 있습니다.");
	}

	@Override
	protected void runMain() {
		//사용하지 않음
	}
}
