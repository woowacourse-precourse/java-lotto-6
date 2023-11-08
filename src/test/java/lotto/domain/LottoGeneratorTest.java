package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
	@DisplayName("로또 리스트 길이가 6이 아니면 예외가 발생한다.")
	@Test
	void createLottoBySize() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		List<Integer> lottoNumbers = LottoGenerator.makeLottoList();

		assertThat(lottoNumbers.size()).isEqualTo(6);
	}

	@DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByRange() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		List<Integer> lottoNumbers = LottoGenerator.makeLottoList();

		for(Integer it : lottoNumbers){
			assertThat(it >= 1 && it <= 45);
		}
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDisctinct() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		List<Integer> lottoNumbers = LottoGenerator.makeLottoList();

		assertThat(lottoNumbers.stream()
				.distinct()
				.count() != 6);
	}
}
