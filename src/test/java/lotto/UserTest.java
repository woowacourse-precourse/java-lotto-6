package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest extends NsTest {

	private User user = User.newInstance();

	@DisplayName("지불 금액이 1000원 단위가 아니면 에러 메세지 출력 후 다시 입력 받는다.")
	@Test
	void payMoneyByInvalidUnit() {
		run("1001", "2000");
		Integer money = user.payMoney();
		assertThat(output()).contains(
				"구입금액을 입력해 주세요.",
				"[ERROR] 구입 금액은 1000원 단위로 입력해주세요."
		);
		assertThat(money).isEqualTo(2000);
	}

	@DisplayName("금액 지불하기")
	@Test
	void payMoney() {
		run("1000");
		Integer money = user.payMoney();
		assertThat(output())
				.contains("구입금액을 입력해 주세요.");
		assertThat(money)
				.isEqualTo(1000);
	}

	@DisplayName("로또 정답 일치시키기")
	@Test
	void matchLottos() {
		Lotto answerLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
		Lottos lottos = Lottos.of(
				List.of(
						Lotto.of(
								List.of(1, 2, 3, 4, 5, 6)),
						Lotto.of(
								List.of(1, 2, 3, 7, 8, 9))));
		user.receiveLottos(lottos);
		LottoResults lottoResults = user.matchLottos(answerLotto, 7);
		assertThat(lottoResults)
				.isNotNull();
	}

	@DisplayName("로또 수익률 계산하기")
	@Test
	void calculatePrize() {
		run("1000");
		user.payMoney();
		LottoResults lottoResults = LottoResults.of(
				List.of(LottoResult.FIVE_PLUS_BONUS));
		user.calculatePrize(lottoResults);
		assertThat(output())
				.contains("총 수익률은 3000000.0%입니다.");
	}

	@Override
	protected void runMain() {
	}
}