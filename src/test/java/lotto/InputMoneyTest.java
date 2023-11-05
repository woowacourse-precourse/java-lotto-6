package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputMoneyTest {

	@Test
	void 구매_금액으로_숫자이외를_입력시_에러를_발생시킨다() {
		assertThrows(IllegalArgumentException.class, () -> {
			InputMoney money = new InputMoney("a");
		});
	}

	@Test
	void 구매_금액이_1000원_단위가_아니면_에러를_발생시킨다() {
		assertThrows(IllegalArgumentException.class, () -> {
			InputMoney money = new InputMoney("2500");
		});
	}

	@Test
	void 구매_금액이_1000원_단위이면_정상적으로_처리된다() {
		InputMoney money = new InputMoney("3000");
		assertEquals(3000, money.getMoney());
	}
}