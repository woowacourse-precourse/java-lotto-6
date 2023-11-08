package lotto.domain.vo;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

	@DisplayName("로또 숫자에 일치하는 숫자가 포함여부에 따라 true와 false를 반환한다.")
	@Test
	void hasDuplicateValue() {
		//given
		LottoNumbers sample = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
		LottoNumber duplicatedNumber = LottoNumber.valueOf(1);
		LottoNumber nonDuplicatedNumber = LottoNumber.valueOf(7);

		//when
		boolean result1 = sample.hasDuplicateValue(duplicatedNumber);
		boolean result2 = sample.hasDuplicateValue(nonDuplicatedNumber);
		//then
		Assertions.assertThat(result1).isEqualTo(true);
		Assertions.assertThat(result2).isEqualTo(false);
	}

	@DisplayName("같은 로또 숫자가 들어간 두 로또에 일치하는 숫자 개수가 6이 나와야 한다.")
	@Test
	void countMatchingNumber() {
		//given
		List<Integer> sample = List.of(1, 2, 3, 4, 5, 6);
		new LottoNumbers(sample);
		LottoNumbers lotto1 = new LottoNumbers(sample);
		LottoNumbers lotto2 = new LottoNumbers(sample);
		//when
		int result = lotto1.countMatchingNumber(lotto2);
		//then
		Assertions.assertThat(result).isEqualTo(sample.size());
	}
}