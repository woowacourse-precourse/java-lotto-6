package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoGenerate;
import lotto.object.Lotto;

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
	@DisplayName("당첨 번호 입력 시 1 이상 45 이하의 숫자가 아니면 예외가 발생한다.")
	@Test
	void checkLottoNumber() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 67))).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("1000원 단위로 로또를 구매할 수 있다.")
	@Test
	void purchaseTickets() {
		String result = LottoGenerate.moneyCheck("8000");
		assertThat(result).isEqualTo("8개를 구매했습니다.");
	}
}