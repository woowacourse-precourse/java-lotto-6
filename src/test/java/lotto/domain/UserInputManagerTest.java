package lotto.domain;

import static lotto.domain.LottoGame.*;
import static lotto.domain.LottoNumber.*;
import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputManagerTest {
	static Class<UserInputManager> testClass = UserInputManager.class;

	@DisplayName(LOTTO_PRICE + "의 배수 입력")
	@Test
	public void checkPurchaseAmountIsValidTestWithValidValue() throws Throwable {
		String testMethodName = "checkPurchaseAmountIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "13000");
		} catch (InvocationTargetException e) {
			throw e.getCause();
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
	public void checkPurchaseAmountIsValidTestWithNumberUnderCostUnit() throws
		NoSuchMethodException,
		IllegalAccessException {
		String testMethodName = "checkPurchaseAmountIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, String.valueOf(LOTTO_PRICE - 1));
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] " + LOTTO_PRICE + " 이상의 숫자를 입력하세요.");
		}
	}

	@DisplayName("단위 금액의 배수가 아닌 숫자를 입력하면 예외가 발생한다.")
	@Test
	public void checkPurchaseAmountIsValidTestWithNumberCanNotDividedByCostUnit() throws
		NoSuchMethodException,
		IllegalAccessException {
		String testMethodName = "checkPurchaseAmountIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);
		int value = LOTTO_PRICE + 1;
		while (value % LOTTO_PRICE == 0) {
			value += 1;
		}

		try {
			testMethod.invoke(testClass, String.valueOf(value));
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 구입 금액은 " + LOTTO_PRICE + " 단위로 입력하세요.");
		}
	}

	@DisplayName("1 이상 45 이하의 6개의 숫자를 중복되지 않게 쉼표(,)로 구분해서 입력")
	@Test
	public void checkWinningNumberIsValidTestWithValidValue() throws Throwable {
		String testMethodName = "checkWinningNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "2,5,11,17,19,23");
		} catch (InvocationTargetException e) {
			throw e.getCause();
		}
	}

	@DisplayName("입력이 공백인 경우 예외가 발생한다.")
	@Test
	public void checkWinningNumberIsValidTestWithBlankInput() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkWinningNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "");
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 당첨 번호를 입력하세요.");
		}
	}

	@DisplayName("입력을 쉼표(,)로 구분해서 얻은 값의 갯수가 6개가 아닌 경우 예외가 발생한다.")
	@Test
	public void checkWinningNumberIsValidTestWithMoreThanNumberOFLottoNumbers() throws
		NoSuchMethodException,
		IllegalAccessException {
		String testMethodName = "checkWinningNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "2,5,11,17,19,23,29");
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] " + NUMBER_OF_LOTTO_NUMBERS.getValue() + "개의 숫자를 입력하세요.");
		}
	}

	@DisplayName("입력을 쉼표(,)로 구분해서 얻은 값들 중 숫자가 아닌 값이 있는 경우 예외가 발생한다.")
	@Test
	public void checkWinningNumberIsValidTestWithNotNumber() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkWinningNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "2,,5,11,17,19,23");
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 숫자를 쉼표(',')로 구분하여 입력하세요.");
		}
	}

	@DisplayName("입력을 쉼표(,)로 구분해서 얻은 값들 중 1 이상 45 이하의 수가 아닌 수가 있는 경우 예외가 발생한다.")
	@Test
	public void checkWinningNumberIsValidTestWithNumberNotInRange() throws
		NoSuchMethodException,
		IllegalAccessException {
		String testMethodName = "checkWinningNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "2,5,11,17,19,47");
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] " + MIN_LOTTO_NUMBER.getValue() + " 이상 " + MAX_LOTTO_NUMBER.getValue()
					+ " 이하의 숫자를 입력하세요.");
		}
	}

	@DisplayName("입력을 쉼표(,)로 구분해서 얻은 값들 중 중복된 수가 있는 경우 예외가 발생한다.")
	@Test
	public void checkWinningNumberIsValidTestWithDuplicatedNumber() throws
		NoSuchMethodException,
		IllegalAccessException {
		String testMethodName = "checkWinningNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "2,5,11,17,19,2");
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 서로 다른 숫자를 입력하세요.");
		}
	}

	@DisplayName("1 이상 45 이하의 숫자를 당첨 번호와 중복되지 않게 입력")
	@Test
	public void checkBonusNumberIsValidTestWithValidValue() throws Throwable {
		String testMethodName = "checkBonusNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class, List.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "29", new ArrayList<>(Arrays.asList(2, 5, 11, 17, 19, 23)));
		} catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
			throw e.getCause();
		}
	}

	@DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
	@Test
	public void checkBonusNumberIsValidTestWithBlankInput() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkBonusNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class, List.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "", new ArrayList<>(Arrays.asList(2, 5, 11, 17, 19, 23)));
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 숫자를 입력하세요.");
		}
	}

	@DisplayName("1 이상 45 이하의 수가 아닌 수를 입력하면 예외가 발생한다.")
	@Test
	public void checkBonusNumberIsValidTestWithNumberNotInRange() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkBonusNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class, List.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "47", new ArrayList<>(Arrays.asList(2, 5, 11, 17, 19, 23)));
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] " + MIN_LOTTO_NUMBER.getValue() + " 이상 " + MAX_LOTTO_NUMBER.getValue()
					+ " 이하의 숫자를 입력하세요.");
		}
	}

	@Test
	public void checkBonusNumberIsValidTestWithDuplicatedNumber() throws NoSuchMethodException, IllegalAccessException {
		String testMethodName = "checkBonusNumberIsValid";
		Method testMethod = testClass.getDeclaredMethod(testMethodName, String.class, List.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testClass, "2", new ArrayList<>(Arrays.asList(2, 5, 11, 17, 19, 23)));
		} catch (InvocationTargetException e) {
			assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 당첨 번호와 번호가 중복되었습니다.");
		}
	}
}
