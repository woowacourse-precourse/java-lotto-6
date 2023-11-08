package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {


	@DisplayName("로또 결과 생성 - 1개의 일치, 보너스 번호 없음")
	@Test
	void createLottoResultTest0() {
		LottoResult lottoResult = new LottoResult(1, false);

		Assertions.assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.FAIL);
	}

	@DisplayName("로또 결과 생성 - 3개의 일치, 보너스 번호 없음")
	@Test
	void createLottoResultTest1() {
		LottoResult lottoResult = new LottoResult(3, false);

		Assertions.assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.FIFTH);
	}

	@DisplayName("로또 결과 생성 - 3개의 일치, 보너스 번호 있음")
	@Test
	void createLottoResultTest1_2() {
		LottoResult lottoResult = new LottoResult(3, true);

		Assertions.assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.FIFTH);
	}

	@DisplayName("로또 결과 생성 - 5개의 일치, 보너스 번호 없음")
	@Test
	void createLottoResultTest3() {
		LottoResult lottoResult = new LottoResult(5, false);

		Assertions.assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.THIRD);
	}

	@DisplayName("로또 결과 생성 - 5개의 일치, 보너스 번호 있음")
	@Test
	void createLottoResultTest4() {
		LottoResult lottoResult = new LottoResult(5, true);

		Assertions.assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.SECOND);
	}


}
