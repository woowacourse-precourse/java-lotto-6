package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest extends NsTest {

	@DisplayName("로또 판매 테스트")
	@Test
	void sellLotto() {
		assertRandomUniqueNumbersInRangeTest(
				() -> {
					LottoShop lottoShop = LottoShop.newInstance();
					User user = User.newInstance();
					run("5000");
					lottoShop.sellLotto(user);
					assertThat(output()).contains(
							"구입금액을 입력해 주세요.",
							"5개를 구매했습니다.",
							"[1, 2, 3, 4, 5, 6]",
							"[7, 8, 9, 10, 11, 12]",
							"[13, 14, 15, 16, 17, 18]",
							"[19, 20, 21, 22, 23, 24]",
							"[25, 26, 27, 28, 29, 30]"
					);
				},
				List.of(1, 2, 3, 4, 5, 6),
				List.of(7, 8, 9, 10, 11, 12),
				List.of(13, 14, 15, 16, 17, 18),
				List.of(19, 20, 21, 22, 23, 24),
				List.of(25, 26, 27, 28, 29, 30)
		);
	}

	@Override
	protected void runMain() {

	}
}