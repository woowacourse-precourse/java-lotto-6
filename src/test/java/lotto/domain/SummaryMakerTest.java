package lotto.domain;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;
import lotto.constant.Prize;

public class SummaryMakerTest {

	SummaryMaker summaryMaker;
	private List<Lotto> lottos;
	private List<Integer> winningNumber;
	private int bonusNumber;

	//given
	@BeforeEach
	void setUp() {
		lottos = asList(new Lotto(asList(43, 44, 45, 3, 2, 1)), new Lotto(asList(43, 44, 45, 3, 2, 1)),
			new Lotto(asList(7, 5, 4, 3, 2, 1)), new Lotto(asList(6, 5, 4, 3, 2, 1)),
			new Lotto(asList(45, 44, 43, 42, 41, 40)), new Lotto(asList(1, 2, 3, 4, 5, 45)));

		winningNumber = asList(1, 2, 3, 4, 5, 6);
		bonusNumber = 7;

		summaryMaker = new SummaryMaker();

	}

	@DisplayName("각 등수의 로또가 몇개인지 집계하는 기능 확인")
	@Test
	void summarizeHitTest() {

		//when
		Map<String, Integer> actualResult = summaryMaker.summarizeHit(lottos, winningNumber, bonusNumber);

		//then
		Map<String, Integer> expectedResult = new HashMap<>();
		expectedResult.put(Prize.FIFTH.getHitResult(), 2);
		expectedResult.put(Prize.FOURTH.getHitResult(), 0);
		expectedResult.put(Prize.THIRD.getHitResult(), 1);
		expectedResult.put(Prize.SECOND.getHitResult(), 1);
		expectedResult.put(Prize.FIRST.getHitResult(), 1);

		assertThat(actualResult).containsEntry(Prize.FIFTH.getHitResult(), 2)
			.containsAllEntriesOf(expectedResult)
			.containsExactlyEntriesOf(expectedResult);

	}

	@DisplayName("수익률 계산 기능 확인")
	@Test
	void calculateYieldTest() {
		//given
		int lottoPrice = 1000;
		int purchaseTime = 6;
		summaryMaker.summarizeHit(lottos, winningNumber, bonusNumber);


		//when
		double actualYield = summaryMaker.calculateYield(purchaseTime);

		//then
		double expectedYield =
			(Prize.FIFTH.getMoney() * 2 + Prize.THIRD.getMoney() + Prize.SECOND.getMoney() + Prize.FIRST.getMoney())
				/ (double) (purchaseTime * lottoPrice);

		assertEquals(expectedYield, actualYield);
	}
}
