package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
	}

	// 아래에 추가 테스트 작성 가능

	@DisplayName("로또 번호가 1과 45 사이 숫자가 아닐 때")
	@Test
	void createLottoByWrongRangeNumber() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, -1, 49))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createBonusNumberByDuplicated() {
		assertThatThrownBy(() -> new WinningResult(List.of(1, 2, 3, 4, 5, 6), 6))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스 번호가 범위를 벗어나면 예외 발생")
	@Test
	void createWinningLottoByWrongRangeBonusNumber() {
		assertThatThrownBy(() -> new WinningResult(List.of(1, 2, 3, 4, 5, 6), 46))
				.isInstanceOf(IllegalArgumentException.class);
	}
}