package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

	private static List<Integer> lottoNumberList;

	@DisplayName("로또 번호의 개수가 6개로 제대로 생성되는지 확인한다.")
	@Test
	void 로또_랜덤숫자_생성() {
		LottoNumbers lottoNumbers = new LottoNumbers();
		lottoNumberList = lottoNumbers.setRandomNumbers();

		assertThat(lottoNumberList.size()).isEqualTo(6);
	}
}