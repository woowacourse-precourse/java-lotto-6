package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.ui.SystemMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCompanyTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	private LottoCompany lottoCompany = LottoCompany.newInstance();

	@DisplayName("입력한 당첨 로또 번호가 6개가 아니면 에러 메시지를 출력 후 다시 입력을 받는다.")
	@Test
	void drawLottoByOverSize() {
		run("1,2,3,4,5,6,7",
				"1,2,3,4,5,6",
				"7");
		lottoCompany.drawLotto();
		assertThat(output()).contains(
				SystemMessage.inputLottoNumbers(),
				ERROR_MESSAGE,
				SystemMessage.inputBonusNumber());
	}

	@DisplayName("입력한 당첨 로또 번호에 중복된 숫자가 있으면 에러 메시지를 출력 후 다시 입력을 받는다.")
	@Test
	void drawLottoByDuplicatedNumber() {
		run("1,2,3,4,5,5",
				"1,2,3,4,5,6",
				"7");
		lottoCompany.drawLotto();
		assertThat(output()).contains(
				SystemMessage.inputLottoNumbers(),
				ERROR_MESSAGE,
				SystemMessage.inputBonusNumber());
	}

	@DisplayName("입력한 당첨 로또 번호가 1보다 작거나 45보다 크면 에러 메시지를 출력 후 다시 입력을 받는다.")
	@Test
	void drawLottoByInvalidNumber() {
		run("1,2,3,4,5,100",
				"1,2,3,4,5,6",
				"7");
		lottoCompany.drawLotto();
		assertThat(output()).contains(
				SystemMessage.inputLottoNumbers(),
				ERROR_MESSAGE,
				SystemMessage.inputBonusNumber());
	}

	@DisplayName("입력한 보너스 번호가 1보다 작거나 45보다 크면 에러 메시지를 출력 후 다시 입력을 받는다.")
	@Test
	void drawBonusNumber() {
		run("1,2,3,4,5,6",
				"100",
				"7");
		lottoCompany.drawLotto();
		assertThat(output()).contains(
				SystemMessage.inputBonusNumber(),
				ERROR_MESSAGE);
	}

	@DisplayName("입력한 보너스 번호가 당첨 로또 번호에 포함되면 에러 메시지를 출력 후 다시 입력을 받는다.")
	@Test
	void drawBonusNumberByDuplicatedNumber() {
		run("1,2,3,4,5,6",
				"6",
				"7");
		lottoCompany.drawLotto();
		assertThat(output()).contains(
				SystemMessage.inputBonusNumber(),
				ERROR_MESSAGE);
	}

	@DisplayName("유저 로또 결과 출력 테스트")
	@Test
	void respondLottoResult() {
		assertRandomUniqueNumbersInRangeTest(
				() -> {
					LottoShop lottoShop = LottoShop.newInstance();
					User user = User.newInstance();
					run("2000");
					lottoShop.sellLotto(user);
					run("1,2,3,4,5,6", "7");
					lottoCompany.drawLotto();
					lottoCompany.respondLottoResult(user);
					assertThat(output()).contains(
							"3개 일치 (5,000원) - 0개",
							"4개 일치 (50,000원) - 0개",
							"5개 일치 (1,500,000원) - 0개",
							"5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
							"6개 일치 (2,000,000,000원) - 1개",
							"총 수익률은 101500000.0%입니다.");
				},
				List.of(1, 2, 3, 4, 5, 6),
				List.of(2, 3, 4, 5, 6, 7)
		);
	}

	@Override
	protected void runMain() {
	}
}