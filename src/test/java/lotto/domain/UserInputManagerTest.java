package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputManagerTest {
	private final static int COST_UNIT = 1000;
	static Class<UserInputManager> testClass = UserInputManager.class;

	@Test
	public void checkPurchaseAmountIsValidTestWithValidValue() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkPurchaseAmountIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);
		try {
			testMethod.invoke(testClass, "13000");
		} catch (InvocationTargetException e) {
			throw new RuntimeException();
		}
	}

	@DisplayName("숫자 이외의 값을 입력하면 예외가 발생한다.")
	@Test
	public void checkPurchaseAmountIsValidTestWithNotNumber() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkPurchaseAmountIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "이게숫자로보이니");
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 숫자를 입력하세요.");
		}
	}

	@DisplayName("단위 금액 이하의 숫자를 입력하면 예외가 발생한다.")
	@Test
	public void checkPurchaseAmountIsValidTestWithNumberUnderCostUnit() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkPurchaseAmountIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, String.valueOf(COST_UNIT - 1));
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] " + COST_UNIT + " 이상의 숫자를 입력하세요.");
		}
	}

	@DisplayName("단위 금액의 배수가 아닌 숫자를 입력하면 예외가 발생한다.")
	@Test
	public void checkPurchaseAmountIsValidTestWithNumberCanNotDividedByCostUnit() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkPurchaseAmountIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);
		int value = COST_UNIT + 1;
		while (value % COST_UNIT == 0) {
			value += 1;
		}

		try {
			testMethod.invoke(testClass, String.valueOf(value));
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입 금액은 " + COST_UNIT + " 단위로 입력해주세요.");
		}
	}
}
