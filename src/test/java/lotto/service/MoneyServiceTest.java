package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Money;

public class MoneyServiceTest {

	private MoneyService moneyService;
	int money;

	@BeforeEach
	void setUp() {
		moneyService = new MoneyService();
		money = 5000;
	}

	@DisplayName("Money 객체 생성 여부 확인")
	@Test
	void testCreateMoney() {
		Money moneyObj = moneyService.createMoney(money);
		assertNotNull(moneyObj);
		assertEquals(moneyObj.money(), money);
	}
}