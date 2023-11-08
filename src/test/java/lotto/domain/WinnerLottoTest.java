package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("당첨 로또")
class WinnerLottoTest {

	@DisplayName("입력한 번호의 개수가 6개가 아니면 예외 발생")
	@ParameterizedTest
	@MethodSource("wrongNumbersSizeDummy")
	void createWinnerLottoWithWrongNumberSizeExceptionTest(final List<Integer> winnerNumbers,
		final Integer bonusNumber) {
		assertThatThrownBy(() -> WinnerLotto.create(winnerNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 번호에 중복된 숫자를 입력한 경우 예외 발생")
	@ParameterizedTest
	@MethodSource("duplicatedNumberInNumbersDummy")
	void createWinnerLottoWithDuplicatedNumberExceptionTest(final List<Integer> winnerNumbers,
		final Integer bonusNumber) {
		assertThatThrownBy(() -> WinnerLotto.create(winnerNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("입력한 당첨 번호와 보너스 번호가 중복된 경우 예외 발생.")
	@ParameterizedTest
	@MethodSource("duplicatedNumberBetweenNumbersAndBonusNumber")
	void createWinnerLottoWithDuplicatedNumberBetweenNumbersAndBonusNumberExceptionTest(
		final List<Integer> winnerNumbers, final Integer bonusNumber) {
		assertThatThrownBy(() -> WinnerLotto.create(winnerNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("당첨 로또 생성 성공")
	@ParameterizedTest
	@MethodSource("createWinneLottoSuccessDummy")
	void createWinnerLottoSuccessTest(final List<Integer> winnerNumbers,
		final Integer bonusNumber) {
		assertDoesNotThrow(() -> WinnerLotto.create(winnerNumbers, bonusNumber));
	}


	static Stream<Arguments> wrongNumbersSizeDummy() {
		return Stream.of(
			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 6, 7),
				10),

			Arguments.arguments(
				List.of(1, 2, 3, 4),
				10),

			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 6, 8, 9),
				10),

			Arguments.arguments(
				List.of(1, 2),
				10)
		);
	}

	static Stream<Arguments> duplicatedNumberInNumbersDummy() {
		return Stream.of(
			Arguments.arguments(
				List.of(1, 2, 3, 2, 5, 6),
				10),

			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 5),
				10),

			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 1),
				10),

			Arguments.arguments(
				List.of(1, 2, 2, 2, 3, 5),
				10)
		);
	}


	static Stream<Arguments> duplicatedNumberBetweenNumbersAndBonusNumber() {
		return Stream.of(
			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 6),
				1),

			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 8),
				8),

			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 10),
				10),

			Arguments.arguments(
				List.of(1, 2, 4, 11, 3, 5),
				4)
		);
	}


	static Stream<Arguments> createWinneLottoSuccessDummy() {
		return Stream.of(
			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 6),
				11),

			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 8),
				18),

			Arguments.arguments(
				List.of(1, 2, 3, 4, 5, 10),
				20),

			Arguments.arguments(
				List.of(1, 2, 4, 11, 3, 5),
				41)
		);
	}
}