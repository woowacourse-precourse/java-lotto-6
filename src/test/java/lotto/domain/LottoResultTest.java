package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

	@DisplayName("로또 결과 생성 - 1개의 일치, 보너스 번호 없음")
	@Test
	void createLottoResultTest0() {
		LottoResult lottoResult = new LottoResult(1, false);

		assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.FAIL);
	}

	@DisplayName("로또 결과 생성 - 3개의 일치, 보너스 번호 없음")
	@Test
	void createLottoResultTest1() {
		LottoResult lottoResult = new LottoResult(3, false);

		assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.FIFTH);
	}

	@DisplayName("로또 결과 생성 - 3개의 일치, 보너스 번호 있음")
	@Test
	void createLottoResultTest1_2() {
		LottoResult lottoResult = new LottoResult(3, true);

		assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.FIFTH);
	}

	@DisplayName("로또 결과 생성 - 5개의 일치, 보너스 번호 없음")
	@Test
	void createLottoResultTest3() {
		LottoResult lottoResult = new LottoResult(5, false);

		assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.THIRD);
	}

	@DisplayName("로또 결과 생성 - 5개의 일치, 보너스 번호 있음")
	@Test
	void createLottoResultTest4() {
		LottoResult lottoResult = new LottoResult(5, true);

		assertThat(lottoResult.getWinningRank()).isEqualTo(WinningRank.SECOND);
	}

	@DisplayName("로또 결과 생성 중 예외 발생 - -1개의 일치")
	@Test
	void createLottoResultByMinusMatchCount() {
		assertThatThrownBy(() -> new LottoResult(-1, false))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 결과 생성 중 예외 발생 - 6개의 일치와 보너스 번호 일치")
	@Test
	void createLottoResultBy6MatchCountAndMatchBonusNumber() {
		assertThatThrownBy(() -> new LottoResult(6, true))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
