package lotto.domain;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;
import lotto.Prize;

public class SummaryMakerTest {

	private static List<Lotto> lottos;
	private static List<Integer> winningNumber;
	private static int bonusNumber;

	SummaryMaker summaryMaker = new SummaryMaker();

	//given
	@BeforeAll
	static void setUp() {
		lottos = asList(
			new Lotto(asList(43, 44, 45, 3, 2, 1)),
			new Lotto(asList(43, 44, 45, 3, 2, 1)),
			new Lotto(asList(7, 5, 4, 3, 2, 1)),
			new Lotto(asList(6, 5, 4, 3, 2, 1)),
			new Lotto(asList(45, 44, 43, 42, 41, 40)),
			new Lotto(asList(1, 2, 3, 4, 5, 45))
		);

		winningNumber = asList(1, 2, 3, 4, 5, 6);
		bonusNumber = 7;

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

		assertThat(actualResult)
			.containsEntry(Prize.FIFTH.getHitResult(), 2)
			.containsAllEntriesOf(expectedResult)
			.containsExactlyEntriesOf(expectedResult);

	}

}
