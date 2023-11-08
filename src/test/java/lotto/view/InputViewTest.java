package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("입력 처리")
class InputViewTest extends IOTest {

	private final InputView inputView = new InputView();


	@DisplayName("현금 입력값 정상적으로 받아오는 경우")
	@ParameterizedTest()
	@ValueSource(strings = {"1000", "2000", "3000", "4000", "5000"})
	void createCashByInputSuccessTest(final String input) {
		assertDoesNotThrow(() -> {
			systemIn(input);
			inputView.requestCash();
		});
	}


	@DisplayName("현금 입력시 숫자 이외의 값을 입력한 경우 예외 발생")
	@ParameterizedTest()
	@ValueSource(strings = {"100f", "hello", "$%%", "40re", "ㅋㅋㅋ"})
	void createCashByNotNumberInputExceptionTest(final String input) {
		assertThrows(IllegalArgumentException.class,
			() -> {
				systemIn(input);
				inputView.requestCash();
			}
		);

	}

	@DisplayName("현금 입력시 공백을 입력한 경우 예외 발생")
	@ParameterizedTest()
	@ValueSource(strings = {" "})
	void createCashByBlankInputExceptionTest(final String input) {
		assertThrows(IllegalStateException.class,
			() -> {
				systemIn(input);
				inputView.requestCash();
			}
		);
	}

	@DisplayName("당첨 번호를 정상적으로 받아오는 경우")
	@ParameterizedTest()
	@ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,9", "1,2,3,4,5,11", "1,2,3,4,5,12",
		"1,2,3,4,5,42"})
	void createWinnerNumbersSuccessTest(final String input) {
		assertDoesNotThrow(() -> {
			systemIn(input);
			inputView.requestWinnerNumbers();
		});
	}


	@DisplayName("입력한 당첨 번호에 숫자가 아닌 값이 있는 경우 예외 발생")
	@ParameterizedTest()
	@ValueSource(strings = {"1,2,3,4,5,z", "1,2,3,4,5,% ", "1,2,3,4,5,ㅎ ", "1,2,3,4,5,!",
		"1,2,3,4,5,."})
	void createWinnerNumbersWithNotNumberExceptionTest(final String input) {
		assertThrows(IllegalArgumentException.class,
			() -> {
				systemIn(input);
				inputView.requestWinnerNumbers();
			}
		);
	}

	@DisplayName("당첨 번호 입력 형식을 준수하지 않은 경우 예외 발생")
	@ParameterizedTest()
	@ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1/2/3/4/5/6 ", "1-2-3-4-5-6", "1,2,3,4,5,6,",
		",1,2,3,4,5,6"})
	void createWinnerNumbersWithWrongNumbersSizeExceptionTest(final String input) {
		assertThrows(IllegalArgumentException.class,
			() -> {
				systemIn(input);
				inputView.requestWinnerNumbers();
			}
		);
	}


	@DisplayName("당첨 번호 입력시 공백을 입력한 경우 예외 발생")
	@ParameterizedTest()
	@ValueSource(strings = {" "})
	void createWinnerNumbersWithBlankExceptionTest(final String input) {
		assertThrows(IllegalStateException.class,
			() -> {
				systemIn(input);
				inputView.requestWinnerNumbers();
			}
		);
	}


	@DisplayName("보너스 번호를 정상적으로 받아오는 경우")
	@ParameterizedTest()
	@ValueSource(strings = {"1", "12", "22", "38", "39"})
	void createBonusNumberSuccessTest(final String input) {
		assertDoesNotThrow(() -> {
			systemIn(input);
			inputView.requestBonusNumber();
		});
	}


	@DisplayName("입력한 보너스 번호에 숫자가 아닌 값이 있는 경우 예외 발생")
	@ParameterizedTest()
	@ValueSource(strings = {"1ㅋ", "12#", "..", "hello", "3 "})
	void createBonusNumberWithNotNumberExceptionTest(final String input) {
		assertThrows(IllegalArgumentException.class,
			() -> {
				systemIn(input);
				inputView.requestBonusNumber();
			}
		);
	}

	@DisplayName("보너스 번호를 입력시 공백을 입력한 경우 예외 발생")
	@ParameterizedTest()
	@ValueSource(strings = {" "})
	void createBonusNumberWithBlankExceptionTest(final String input) {
		assertThrows(IllegalStateException.class,
			() -> {
				systemIn(input);
				inputView.requestBonusNumber();
			}
		);
	}


}