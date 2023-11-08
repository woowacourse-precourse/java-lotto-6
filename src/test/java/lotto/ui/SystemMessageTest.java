package lotto.ui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SystemMessageTest {

	@DisplayName("금액 입력 문구를 테스트한다.")
	@Test
	void 금액_입력_문구_테스트() {
		// when
		String message = SystemMessage.inputMoney();
		// then
		assertEquals(message, "구입금액을 입력해 주세요.");
	}

	@DisplayName("로또 통계 문구를 테스트한다.")
	@Test
	void 로또_통계_문구_테스트() {
		// when
		String message = SystemMessage.lottoStatistics();
		// then
		assertEquals(message, "\n당첨 통계\n---");
	}

	@DisplayName("로또 번호 입력 문구를 테스트한다.")
	@Test
	void 로또_번호_입력_문구_테스트() {
		// when
		String message = SystemMessage.inputLottoNumbers();
		// then
		assertEquals(message, "\n당첨 번호를 입력해 주세요.");
	}

	@DisplayName("보너스 번호 입력 문구를 테스트한다.")
	@Test
	void 보너스_번호_입력_문구_테스트() {
		// when
		String message = SystemMessage.inputBonusNumber();
		// then
		assertEquals(message, "\n보너스 번호을 입력해 주세요.");
	}

	@DisplayName("로또 결과 문구를 테스트한다.")
	@Test
	void 로또_구매_개수_문구_테스트() {
		// when
		String message = SystemMessage.buyLottoCount(1);
		// then
		assertEquals(message, "\n1개를 구매했습니다.");
	}

	@DisplayName("수익률 문구를 테스트한다.")
	@Test
	void 수익률_문구_테스트() {
		// when
		String message = SystemMessage.totalRevenueRate(1.19);
		// then
		assertEquals(message, "총 수익률은 1.2%입니다.");
	}
}