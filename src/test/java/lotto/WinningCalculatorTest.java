package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Controller.WinningCalculator;
import lotto.Enum.Prize;

public class WinningCalculatorTest {
	private WinningCalculator winningCalculator;

	@BeforeEach
	void setUp() {
		winningCalculator = new WinningCalculator();
	}

	@Test
	@DisplayName("Prize 조건을 충족하는 로또가 없을 경우 그 어떤 Prize도 반환하지 않는다.")
	void testCalculatePrizesWithNoWinners() {
		WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
		BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
		WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);
		List<Lotto> lottos = List.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)));

		Map<Prize, Integer> prizes = winningCalculator.calculatePrizes(winningInfo, lottos);

		for (Prize prize : Prize.values()) {
			assertEquals(0, prizes.get(prize));
		}
	}

	@Test
	@DisplayName("Prize 조건을 충족하는 로또가 있을 경우 해당 Prize를 반환한다.")
	void testCalculatePrizesWithWinners() {
		WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
		BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
		WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);
		List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

		Map<Prize, Integer> prizes = winningCalculator.calculatePrizes(winningInfo, lottos);

		assertEquals(1, prizes.get(Prize.FIFTH));
	}

	@Test
	@DisplayName("수익률을 올바르게 계산한다.")
	void testCalculateProfitRate() {
		Map<Prize, Integer> prizes = Map.of(Prize.FIFTH, 1);
		int pay = 8_000;

		double profitRate = winningCalculator.calculateProfitRate(prizes, pay);

		assertEquals(62.5, profitRate);
	}
}
