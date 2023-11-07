package lotto;

import static model.FixedValues.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import features.Statistics;
import model.Data;

public class StatisticsTest {
	
	private final List<List<Integer>> test_list=Arrays.asList(
														Arrays.asList(1,2,3,4,5,6),
														Arrays.asList(1,5,6,27,28,29),
														Arrays.asList(2,5,6,14,15,42),
														Arrays.asList(1,2,5,6,14,42)
														);
	private final List<Integer> test=Arrays.asList(1,2,5,6,14,29);
	private final int tbonus=42;
	
	private class TestData extends Data {
		public List<List<Integer>> getLottoList() {
			return test_list;
		}
		public List<Integer> getLottoNumbers() {
			return test;
		}
		public int getBonus() {
			return tbonus;
		}
	}
	
	@DisplayName("당첨 번호와 발행 번호를 비교하여 일치하는 번호의 개수를 정확히 구한다.")
	@Test
	void correctMatch() {
		Statistics teststat=CREATOR.statCreator(new TestData());
		int testresult=teststat.forMathcingTest(Arrays.asList(2,6,14,19,30,45),
												Arrays.asList(6,14,35,42,45));
		
		assertEquals(3, testresult);
	}
	
	@DisplayName("보너스 번호가 있을 경우 true,없을 경우 false를 반환한다.")
	@Test
	void isThereABonusNum() {
		Statistics teststat=CREATOR.statCreator(new TestData());
		boolean testresult=teststat.forBonusTest(Arrays.asList(37,38,39,40,41,43));
		
		assertFalse(testresult);
	}
	
	@DisplayName("일치하는 번호 개수에 따라 배열의 정확한 위치의 인덱스가 증가한다.")
	@Test
	void correctIndex() {
		Statistics teststat=CREATOR.statCreator(new TestData());
		int [] testresult=teststat.forCountingTest(6, true, new int[] {3,4,0,0,1});
		
		assertArrayEquals(new int[] {3,4,0,0,2}, testresult);
	}
	
	@DisplayName("일치하는 번호 개수에 따라 정확한 상금을 출력한다.")
	@Test
	void noFraud() {
		Statistics teststat=CREATOR.statCreator(new TestData());
		int testresult=teststat.forProfitTest(new int[] {1,2,1,1,0});
		
		assertEquals(31605000, testresult);
	}
	
	@DisplayName("상금을 수익률로 전환한다.")
	@Test
	void howManyTimes() {
		Statistics teststat=CREATOR.statCreator(new TestData());
		double testresult=teststat.forRateTest(30055000);
		
		assertEquals(751375.0, testresult);
	}
}
