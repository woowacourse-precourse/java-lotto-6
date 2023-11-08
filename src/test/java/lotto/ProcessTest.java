package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.dataObjects.Lotto;
import lotto.dataObjects.Money;
import lotto.enumContainer.LottoResult;
import lotto.io.PrintGenerator;
import lotto.io.PrintGeneratorImpl;

public class ProcessTest extends NsTest {

	@DisplayName("금액에서 가격으로 나눈 값을 반환해야 한다.")
	@Test
	void calculateAmountTest() {
		Money money = new Money(1000);

		assertThat(money.calculateAmount()).isEqualTo(1);
	}

	@DisplayName("일치한 번호 갯수에 따라 로또의 수를 반환해야 한다.")
	@Test
	void matchTest() {
		Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
		Money money = new Money(1000);
		PrintGenerator printer = new PrintGeneratorImpl();

		lotto.checkLotto(7, List.of(List.of(1,2,3,4,8,9)), money);
		printer.printWinningStatistics();

		assertThat(output()).contains("4개 일치 (50,000원) - 1개");
		LottoResult.FOUR.init();
	}

	@Test
	void calculateProfitRateTest() {
		Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
		Money money = new Money(1000);
		PrintGenerator printer = new PrintGeneratorImpl();

		lotto.checkLotto(7, List.of(List.of(1,2,3,7,8,9)), money);
		printer.printBenefit(money.calculateProfitRate());

		assertThat(output()).isEqualTo("총 수익률은 500.0%입니다.");
		LottoResult.THREE.init();
	}
	
	@Override
	protected void runMain() {
		//사용하지 않음
	}
}
