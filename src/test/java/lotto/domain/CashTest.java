package lotto.domain;

import lotto.dto.RequestCash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("현금")
class CashTest {

	@DisplayName("1000원 보다 작은 금액 입력시 예외 발생")
	@ParameterizedTest()
	@ValueSource(ints = {100, 200, 300, 400, 500})
	void createCashSmallerUnitExceptionTest(final int amount) {
		assertThrows(IllegalArgumentException.class,
			() -> {
				final RequestCash requestCash = RequestCash.of(amount);
				Cash.create(
					requestCash.depositAmount(),
					requestCash.spendAmount()
				);
			}
		);
	}

	@DisplayName("1000원으로 나누어 떨어지지 않는 금액 입력시 예외 발생")
	@ParameterizedTest()
	@ValueSource(ints = {1001, 2002, 3003, 4004, 5005})
	void createCashNotDivisibleAmountExceptionTest(final int amount) {
		assertThrows(IllegalArgumentException.class,
			() -> {
				final RequestCash requestCash = RequestCash.of(amount);
				Cash.create(
					requestCash.depositAmount(),
					requestCash.spendAmount()
				);
			}
		);
	}

	@DisplayName("잘못된 지출 초기 설정값이 입력되는 경우 예외 발생")
	@ParameterizedTest()
	@ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
	void createCashWithWrongInitSpendAmountExceptionTest(final int wrongInitAmount) {
		assertThrows(IllegalStateException.class,
			() -> {
				Cash.create(
					1000,
					wrongInitAmount
				);
			}
		);
	}


	@DisplayName("생성 성공 테스트")
	@ParameterizedTest()
	@ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
	void createCashSuccessTest(final int amount) {
		assertDoesNotThrow(() -> {
			final RequestCash requestCash = RequestCash.of(amount);
			Cash.create(
				requestCash.depositAmount(),
				requestCash.spendAmount()
			);
		});
	}


	@DisplayName("지불 기능 성공 테스트")
	@ParameterizedTest
	@MethodSource("cashDummy")
	void spendSuccessTest(final List<Cash> cashDummy) {
		final List<Cash> cashes = cashDummy;

		boolean result = cashes.stream()
			.allMatch(cash -> cash.spendOneUnit() == true);

		assertThat(result).isTrue();

	}


	@DisplayName("지불 기능 실패 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
	void spendNotSuccessTest(final int amount) {
		final RequestCash requestCash = RequestCash.of(amount);
		final Cash cash = Cash.create(requestCash.depositAmount(),
			requestCash.spendAmount());

		while (cash.isAfford()) {
			cash.spendOneUnit();
		}
		final Boolean isSpend = cash.spendOneUnit();

		assertEquals(false, isSpend);
	}

	static Stream<Arguments> cashDummy() {
		return Stream.of(
			Arguments.arguments(List.of(
				Cash.create(1000, 0),
				Cash.create(2000, 0),
				Cash.create(3000, 0),
				Cash.create(4000, 0),
				Cash.create(5000, 0))
			)
		);
	}
}