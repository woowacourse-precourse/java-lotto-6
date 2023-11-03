package lotto.numbergenerator;

import static lotto.enums.AmountEnum.MAX_VALUE;
import static lotto.enums.AmountEnum.MIN_VALUE;
import static lotto.enums.LottoNumberEnum.*;
import static lotto.enums.LottoNumberEnum.END_VALUE;
import static lotto.enums.LottoNumberEnum.START_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.IllegalAmountException;
import lotto.exception.IllegalNullTypeException;
import lotto.exception.IllegalNumberTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    private static final NumberGenerator numberGenerator = new NumberGenerator();
    private final static String NORMAL_LOTTO_NUMBER = "1,5,23,45,7,8";
    private final static String LOTTO_NUMBER_CONTAIN_TEXT = "s,5,23,45,7,8";
    private final static String LOTTO_NUMBER_CONTAIN_SPACE = " ,5,23,45,7,8";
    private final static String LOTTO_NUMBER_CONTAIN_SPECIAL_TEXT = "s,5,23,45,7,8";
    private final static String NORMAL_AMOUNT = "5000";
    private static final String UNDER_MIN_VALUE = "500";
    private static final String MIXED_VALUE = "5500";
    private static final String NUMBERS_CONTAIN_TEXT = "1000S";
    private static final String NUMBERS_CONTAIN_SPACE = "10 00";
    private static final String NUMBERS_CONTAIN_SPECIAL_TEXT = "10#00";

    @DisplayName("범위가 1부터 45, 사이즈가 6인 리스트를 랜덤으로 반환한다.")
    @Test
    void createRandomUniqueNumber() {
        List<Integer> randomUniqueNumber = numberGenerator.createRandomUniqueNumber();
        assertThat(randomUniqueNumber.size()).isEqualTo(SIZE.getValue());

        List<Integer> exceptionNumbers = randomUniqueNumber.stream()
                .filter(number -> number < START_VALUE.getValue() || number > END_VALUE.getValue()).toList();
        assertThat(exceptionNumbers).isEmpty();
    }
    @DisplayName("문자열을 로또형식에 맞게 숫자리스트로 변환한다.")
    @Test
    void createLottoNumbersFromConsole() {
        List<Integer> numbersFromConsole = numberGenerator.createLottoNumbersFromConsole(NORMAL_LOTTO_NUMBER);
        assertThat(numbersFromConsole.size()).isEqualTo(SIZE.getValue());
    }

    @DisplayName("입력된 문자열이 숫자가 아니면 예외를 발생한다.")
    @Test
    void createLottoNumbersFromConsoleException() {
        assertThatThrownBy(()->numberGenerator.createLottoNumbersFromConsole(LOTTO_NUMBER_CONTAIN_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createLottoNumbersFromConsole(LOTTO_NUMBER_CONTAIN_SPACE))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createLottoNumbersFromConsole(LOTTO_NUMBER_CONTAIN_SPECIAL_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);

        assertThatThrownBy(()->numberGenerator.createLottoNumbersFromConsole(null))
                .isInstanceOf(IllegalNullTypeException.class);
    }

    @DisplayName("숫자로 된 문자열을 최소금액이 1000인 정수로 반환한다.")
    @Test
    void createAmountFromConsole() {
        Integer amountFromConsole = numberGenerator.createAmountFromConsole(NORMAL_AMOUNT);
        assertThat(amountFromConsole).isBetween(MIN_VALUE.getAmount(), MAX_VALUE.getAmount());
    }


    @DisplayName("단위 금액이 1000원 이하라면 예외를 발생한다.")
    @Test
    void createAmountFromConsoleRangeException() {
        assertThatThrownBy(() -> numberGenerator.createAmountFromConsole(UNDER_MIN_VALUE))
                .isInstanceOf(IllegalAmountException.class);
        assertThatThrownBy(()->numberGenerator.createAmountFromConsole(MIXED_VALUE))
                .isInstanceOf(IllegalAmountException.class);
    }

    @DisplayName("입력된 문자열이 숫자가 아니면 예외를 발생한다.")
    @Test
    void createAmountFromConsoleTypeException() {
        assertThatThrownBy(()->numberGenerator.createAmountFromConsole(NUMBERS_CONTAIN_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createAmountFromConsole(NUMBERS_CONTAIN_SPACE))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createAmountFromConsole(NUMBERS_CONTAIN_SPECIAL_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);

        assertThatThrownBy(()->numberGenerator.createAmountFromConsole(null))
                .isInstanceOf(IllegalNullTypeException.class);
    }
}