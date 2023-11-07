package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Enum.Prize;
import lotto.View.OutputView;

public class OutputViewTest {
	@Test
	@DisplayName("로또 구매 후, 로또 개수가 올바르게 출력되는지 확인")
	public void testPrintPurchasedMessage() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		OutputView.printPurchasedMessage(5, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
		String output = outputStream.toString();

		assertThat(output).contains("5개를 구매했습니다.");
	}

	@Test
	@DisplayName("Test printResult")
	public void testPrintResult() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		Map<Prize, Integer> prizes = new HashMap<>();
		prizes.put(Prize.findPrizeByMatch(3, false), 1);
		OutputView.printResult(prizes, 62.5);
		String output = outputStream.toString();

		assertThat(output).contains("당첨 통계", "3개 일치 (5,000원) - 1개", "총 수익률은 62.5%입니다.");
	}
}
