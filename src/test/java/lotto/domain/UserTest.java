package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

	@Test
	@DisplayName("User 생성자 테스트")
	public void testConstructorValidMoney() {
		// given
		Integer money = 5000;

		// when
		User user = new User(money);

		// then
		assertEquals(money, user.getMoney());
	}

	@Test
	@DisplayName("User 생성자 테스트 - 1000원 단위가 아닌 금액")
	public void testConstructorInvalidMoney() {
		// given
		Integer invalidMoney = 1500;

		// when & then
		assertThrows(IllegalArgumentException.class, () -> new User(invalidMoney));
	}

	@Test
	@DisplayName("User 생성자 테스트 - 1000원 단위가 아닌 금액")
	public void testGetLottoPaper() {
		// given
		Integer money = 10000;
		User user = new User(money);

		// when
		LottoPaper lottoPaper = user.getLottoPaper();

		// then
		assertNotNull(lottoPaper);
	}
}
