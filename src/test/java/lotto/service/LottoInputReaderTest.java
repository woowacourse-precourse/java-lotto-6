package lotto.service;

import static lotto.exception.ExceptionConstant.ERROR_PREFIX;
import static lotto.exception.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT_MESSAGE;
import static lotto.io.read.InputMessage.READ_LOTTO_BONUS_NUMBER;
import static lotto.io.read.InputMessage.READ_LOTTO_WIN_NUMBERS;
import static lotto.io.read.InputMessage.READ_PURCHASE_AMOUNT_MESSAGE;
import static lotto.utils.LottoConstant.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import lotto.io.read.InputReader;
import lotto.validation.LottoValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class LottoInputReaderTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    LottoInputReader lottoInputReader;

    @Mock
    InputReader mockReader;

    @Spy
    LottoValidator spyValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lottoInputReader = new LottoInputReader(mockReader, spyValidator);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 사용자에게_로또_구매_금액을_입력받을때_입력_메시지를_출력한다() throws Exception {
        //Arrange
        String userInput = "3000";
        int expected = 3000;

        when(mockReader.readLine()).thenReturn(userInput);
        doNothing()
                .when(spyValidator)
                .verifyPurchaseAmount(userInput);

        //Act
        lottoInputReader.readPurchaseAmount();

        //Assert
        assertThat(outputStreamCaptor.toString())
                .contains(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    @Test
    void 사용자가_유효한_로또_구매_금액을_입력하면_반환한다() {
        //Arrange
        String userInput = "3000";
        int expected = 3000;

        when(mockReader.readLine()).thenReturn(userInput);
        doNothing()
                .when(spyValidator)
                .verifyPurchaseAmount(userInput);

        //Act
        int actual = lottoInputReader.readPurchaseAmount();

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @CsvSource(value = {"0", "-1", "999", "' ", "abcd"})
    @ParameterizedTest
    void 사용자가_유효하지_않은_로또_구매_금액을_입력하면_재입력_받는다(String invalidInput) {
        //Arrange
        String validInput = "2000";
        int expected = 2000;

        when(mockReader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        doThrow(new IllegalArgumentException("Invalid amount"))
                .when(spyValidator)
                .verifyPurchaseAmount(invalidInput);

        doNothing()
                .when(spyValidator)
                .verifyPurchaseAmount(validInput);

        //Act
        int actual = lottoInputReader.readPurchaseAmount();

        //Assert
        assertThat(expected).isEqualTo(actual);

        verify(mockReader, times(2)).readLine();
        verify(spyValidator).verifyPurchaseAmount(invalidInput);
        verify(spyValidator).verifyPurchaseAmount(validInput);
    }

    @CsvSource(value = {"0", "-1", "999", "' ", "abcd"})
    @ParameterizedTest
    void 사용자가_유효하지_않은_로또_구매_금액을_입력하면_예외_메시지를_출력한다(String invalidInput) {
        //Arrange
        String validInput = "2000";

        when(mockReader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        //Act
        lottoInputReader.readPurchaseAmount();

        //Assert
        assertThat(outputStreamCaptor.toString()).contains(
                String.format("%s %s", ERROR_PREFIX, INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage()));
    }

    @Test
    void 올바른_당첨_숫자를_입력받으면_정렬하여_반환한다() {
        //Arrange
        String validInput = "6,5,4,3,2,1";

        when(mockReader.readLine())
                .thenReturn(validInput);

        doNothing()
                .when(spyValidator)
                .verifyWinNumbers(validInput);

        //Act
        List<Integer> numbers = lottoInputReader.readWinNumbers();

        //Assert
        assertThat(numbers)
                .hasSize(LOTTO_NUMBER_COUNT)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 사용자에게_당첨_숫자를_입력받을때_입력_메시지를_출력한다() {
        String validInput = "6,5,4,3,2,1";

        when(mockReader.readLine())
                .thenReturn(validInput);

        doNothing()
                .when(spyValidator)
                .verifyWinNumbers(validInput);

        //Act
        lottoInputReader.readWinNumbers();

        //Assert
        assertThat(outputStreamCaptor.toString())
                .contains(READ_LOTTO_WIN_NUMBERS.getMessage());
    }

    @MethodSource("winNumbersProvider")
    @ParameterizedTest
    void 사용자가_유효하지_않은_당첨_숫자를_입력하면_예외_메시지를_출력한다(String invalidInput, String errorMessage) {
        //Arrange
        String validInput = "1,2,3,4,5,6";

        when(mockReader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        //Act
        lottoInputReader.readWinNumbers();

        //Assert
        assertThat(outputStreamCaptor.toString()).contains(
                String.format("%s %s", ERROR_PREFIX, errorMessage));
    }

    @CsvSource(value = {"1,2,3,4,5,6,7", "1,2,3,4,6,6", "1,100,2,3,4,5", "' '", "abcd"})
    @ParameterizedTest
    void 사용자가_유효하지_않은_당첨_숫자를_입력하면_재입력_받는다(String invalidInput) {
        //Arrange
        String validInput = "1,2,3,4,5,6";

        when(mockReader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        //Act
        List<Integer> numbers = lottoInputReader.readWinNumbers();

        //Assert
        assertThat(numbers).hasSize(LOTTO_NUMBER_COUNT)
                .containsExactly(1, 2, 3, 4, 5, 6);

        verify(mockReader, times(2)).readLine();
        verify(spyValidator).verifyWinNumbers(invalidInput);
        verify(spyValidator).verifyWinNumbers(validInput);
    }

    @Test
    void 올바른_보너스_번호를_입력받고_반환한다() {
        //Arrange
        String bonusNumberInput = "7";
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int expected = 7;

        when(mockReader.readLine())
                .thenReturn(bonusNumberInput);

        //Act
        int actual = lottoInputReader.readBonusNumber(winNumbers);

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 보너스_번호를_입력받을때_입력_메시지를_출력한다() {
        //Arrange
        String bonusNumberInput = "7";
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);

        when(mockReader.readLine())
                .thenReturn(bonusNumberInput);

        //Act
        lottoInputReader.readBonusNumber(winNumbers);

        //Assert
        assertThat(outputStreamCaptor.toString()).contains(READ_LOTTO_BONUS_NUMBER.getMessage());
    }

    @MethodSource("bonusNumberProvider")
    @ParameterizedTest
    void 사용자가_유효하지_않은_보너스_번호를_입력하면_예외_메시지를_출력한다(String invalidInput, String errorMessage) {
        //Arrange
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        String validInput = "7";

        when(mockReader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        //Act
        lottoInputReader.readBonusNumber(winNumbers);

        //Assert
        assertThat(outputStreamCaptor.toString()).contains(
                String.format("%s %s", ERROR_PREFIX, errorMessage));
    }

    @CsvSource(value = {"6", "abcd", "a", "' ", "46"})
    @ParameterizedTest
    void 사용자가_유효하지_않은_보너스_번호를_입력하면_재입력_받는다(String invalidInput) {
        //Arrange
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        String validInput = "7";
        int expected = 7;

        when(mockReader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        //Act
        int actual = lottoInputReader.readBonusNumber(winNumbers);

        //Assert
        assertThat(actual).isEqualTo(expected);

        verify(mockReader, times(2)).readLine();
        verify(spyValidator).verifyBonusNumber(winNumbers, invalidInput);
        verify(spyValidator).verifyBonusNumber(winNumbers, validInput);
    }

    static Stream<Arguments> winNumbersProvider() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6,7", INVALID_LOTTO_NUMBER_SIZE.getMessage()),
                Arguments.of("1,2,3,4,6,6", DUPLICATED_LOTTO_NUMBERS.getMessage()),
                Arguments.of("1,2,3,4,5,47", INVALID_LOTTO_NUMBER_RANGE.getMessage())
        );
    }

    static Stream<Arguments> bonusNumberProvider() {
        return Stream.of(
                Arguments.of("6", DUPLICATED_LOTTO_NUMBERS.getMessage()),
                Arguments.of("a", INVALID_LOTTO_NUMBER_RANGE.getMessage()),
                Arguments.of(" ", INVALID_LOTTO_NUMBER_RANGE.getMessage()),
                Arguments.of("48", INVALID_LOTTO_NUMBER_RANGE.getMessage())
        );
    }
}