package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.vo.LottoNumbers;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	//원래 구현 상 LottoNumbers에서 test해야할 코드이지만 테스트 내용이 겹쳐 여기에 했습니다.
	@DisplayName("당첨 번호가 6개 이하나 이상이라면 예외가 발생한다.")
	@Test
	void underSizeWinnings() {
		//given
		List<Integer> underSizeNumber = List.of(1, 2, 3, 4, 5);
		List<Integer> overSizeNumber = List.of(1, 2, 3, 4, 5, 6, 7);
		//when & then
		//under
		assertThatThrownBy(() -> new LottoNumbers(underSizeNumber))
				.isInstanceOf(LottoException.class);
		//over
		assertThatThrownBy(() -> new LottoNumbers(overSizeNumber))
				.isInstanceOf(LottoException.class);
	}

	@DisplayName("당첨 번호 내에 겹체는 번호가 있을 시 예외가 발생한다.")
	@Test
	void duplicatedWinningNumbers() {
		//given
		List<Integer> sample = List.of(1, 1, 2, 3, 4, 5);
		//when
		assertThatThrownBy(() -> new LottoNumbers(sample))
				//then
				.isInstanceOf(LottoException.class);
	}
}