package lotto.domain;

import static lotto.domain.LottoResultCalculator.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultCalculatorTest {
	static Class<LottoResultCalculator> testClass = LottoResultCalculator.class;

	@DisplayName("금액 입력 시 3글자마다 쉼표(,) 삽입")
	@ParameterizedTest
	@CsvSource(value = {"1000. 1,000원", "10000. 10,000원", "100000. 100,000원", "1000000. 1,000,000원",
		"10000000. 10," + "000,000원", "100000000. 100,000,000원"}, delimiter = '.')
	public void integerToWonTest(String cost, String target) throws Throwable {
		String testMethodName = "integerToWon";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, int.class);
		testMethod.setAccessible(true);

		try {
			assertThat(testMethod.invoke(testClass, Integer.parseInt(cost))).isEqualTo(target);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		}
	}

	@DisplayName("당첨 통계와 수익률 출가")
	@Test
	void printWinningDetailsTest() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		ArrayList<Lotto> lottos = new ArrayList<>();
		ArrayList<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
		int bonusNumber = 7;

		// 모의 객체(Mock) 생성
		Lotto mockLotto = mock(Lotto.class);
		Lotto mockLotto2 = mock(Lotto.class);
		when(mockLotto.confirmWinning(any(), anyInt())).thenReturn(LottoPrize.THREE_MATCH);
		lottos.add(mockLotto);
		when(mockLotto2.confirmWinning(any(), anyInt())).thenReturn(LottoPrize.FIVE_MATCH_WITH_BONUS);
		lottos.add(mockLotto2);

		printWinningDetails(lottos, winningNumber, bonusNumber);

		String actualOutput = outputStream.toString().trim();

		String expectedOutput = """
			당첨 통계
			---
			3개 일치 (5,000원) - 1개
			4개 일치 (50,000원) - 0개
			5개 일치 (1,500,000원) - 0개
			5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
			6개 일치 (2,000,000,000원) - 0개
			총 수익률은 1500250.0%입니다.""";

		assertEquals(expectedOutput, actualOutput);

		System.setOut(System.out);
	}
}
