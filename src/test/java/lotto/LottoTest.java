package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {

	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() ->
				new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		assertThatThrownBy(() ->
				new Lotto(List.of(1, 2, 3, 4, 5, 5)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호가 1보다 작거나 45보다 크면 예외가 발생한다.")
	@Test
	void createLottoByInvalidNumber() {
		assertThatThrownBy(() ->
				new Lotto(List.of(1, 2, 3, 4, 5, 46)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호 오름차순 출력 테스트")
	@Test
	void createLottoSortNumber() {
		Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
		lotto.printNumbers();
		assertThat(output())
				.contains("[1, 2, 3, 4, 5, 6]");
	}

	@DisplayName("로또 일치 확인 테스트")
	@Test
	void matchLottoByLotto() {
		Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
		Lotto answerLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
		Integer bonusNumber = 7;
		LottoResult lottoResult = lotto.match(answerLotto, bonusNumber);
		assertThat(lottoResult)
				.isEqualTo(LottoResult.SIX);
	}

	@DisplayName("로또 번호 포함 확인 테스트")
	@Test
	void lottoContainNumber() {
		Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
		assertThat(lotto.containNumbers(1))
				.isTrue();
		assertThat(lotto.containNumbers(7))
				.isFalse();
	}

	@DisplayName("로또 번호 출력 테스트")
	@Test
	void lottoPrintNumbers() {
		Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
		lotto.printNumbers();
		assertThat(output()).contains("[1, 2, 3, 4, 5, 6]");
	}

	@Override
	protected void runMain() {

	}
}