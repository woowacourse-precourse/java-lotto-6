package lotto.domain;

import static lotto.domain.LottoPrize.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import lotto.domain.Lotto;

class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByNumberNotInRange() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46))).isInstanceOf(IllegalArgumentException.class);
	}

	private static Stream<Arguments> confirmWinningTestMethod() {
		return Stream.of(
			Arguments.of(new HashSet<>(List.of(7, 8, 9, 10, 11, 12)), 13, null),
			Arguments.of(new HashSet<>(List.of(1, 2, 3, 10, 11, 12)), 13, THREE_MATCH),
			Arguments.of(new HashSet<>(List.of(1, 2, 3, 4, 11, 12)), 13, FOUR_MATCH),
			Arguments.of(new HashSet<>(List.of(1, 2, 3, 4, 5, 12)), 13, FIVE_MATCH),
			Arguments.of(new HashSet<>(List.of(1, 2, 3, 4, 5, 12)), 6, FIVE_MATCH_WITH_BONUS),
			Arguments.of(new HashSet<>(List.of(1, 2, 3, 4, 5, 6)), 7, SIX_MATCH)
		);
	}

	@DisplayName("맞춘 번호의 수에 따라서 값을 반환한다.")
	@ParameterizedTest
	@MethodSource("confirmWinningTestMethod")
	void confirmWinningTest(Set<Integer> winningNumbers, int bonusNumber, LottoPrize target) {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		assertThat(lotto.confirmWinning(winningNumbers, bonusNumber)).isEqualTo(target);
	}
}
