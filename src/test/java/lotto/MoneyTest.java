package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
	@DisplayName("올바른 돈 초기화")
	@Test
	void createValidMoney(){
		Money money = new Money("2000");
		assertEquals(2000, money.getMoney());
	}

	@DisplayName("잘못된 형식으로 초기화")
	@Test
	void createMoneyByWrongFormat(){
		assertThatThrownBy(() -> new Money("abc"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("음수 값으로 초기화")
	@Test
	void createMoneyByNegativeNumber(){
		assertThatThrownBy(() -> new Money("-1000"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("1000으로 나누어 떨어지지 않는 값으로 초기화")
	@Test
	void createMoneyByNonDivisibleInput(){
		assertThatThrownBy(() -> new Money("1500"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("1000 미만의 값으로 초기화")
	@Test
	void createMoneyByNumberUnder1000(){
		assertThatThrownBy(() -> new Money("500"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
