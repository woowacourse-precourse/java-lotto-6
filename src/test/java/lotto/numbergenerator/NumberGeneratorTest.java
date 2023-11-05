package lotto.numbergenerator;

import static lotto.enums.AmountEnum.MIN_VALUE;
import static lotto.enums.LottoNumberEnum.*;
import static lotto.enums.LottoNumberEnum.END_VALUE;
import static lotto.enums.LottoNumberEnum.START_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.IllegalAmountException;
import lotto.exception.IllegalOverValueException;
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
    private static final String BONUS_NUMBER = "7";
    private static final String BONUS_NUMBER_OVER = "46";

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
        List<Integer> numbersFromConsole = numberGenerator.createWinningNumbersFromConsole(NORMAL_LOTTO_NUMBER);
        assertThat(numbersFromConsole.size()).isEqualTo(SIZE.getValue());
    }

    @DisplayName("입력된 문자열이 숫자가 아니면 예외를 발생한다.")
    @Test
    void createLottoNumbersFromConsoleException() {
        assertThatThrownBy(()->numberGenerator.createWinningNumbersFromConsole(LOTTO_NUMBER_CONTAIN_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createWinningNumbersFromConsole(LOTTO_NUMBER_CONTAIN_SPACE))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createWinningNumbersFromConsole(LOTTO_NUMBER_CONTAIN_SPECIAL_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);

        assertThatThrownBy(()->numberGenerator.createWinningNumbersFromConsole(null))
                .isInstanceOf(IllegalNullTypeException.class);
    }
    @DisplayName("최소금액이 1000인 금액을 수량으로 환산한다.")
    @Test
    void createAmountToQuantity() {
        Integer amountToQuantity = numberGenerator.createAmountToQuantity(NORMAL_AMOUNT);
        assertThat(amountToQuantity).isEqualTo(Integer.parseInt(NORMAL_AMOUNT)/ MIN_VALUE.getAmount());
    }

    @DisplayName("단위 금액이 1000원 이하라면 예외를 발생한다.")
    @Test
    void createAmountFromConsoleRangeException() {
        assertThatThrownBy(() -> numberGenerator.createAmountToQuantity(UNDER_MIN_VALUE))
                .isInstanceOf(IllegalAmountException.class);
        assertThatThrownBy(()->numberGenerator.createAmountToQuantity(MIXED_VALUE))
                .isInstanceOf(IllegalAmountException.class);
    }

    @DisplayName("입력된 문자열이 숫자가 아니면 예외를 발생한다.")
    @Test
    void createAmountFromConsoleTypeException() {
        assertThatThrownBy(()->numberGenerator.createAmountToQuantity(NUMBERS_CONTAIN_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createAmountToQuantity(NUMBERS_CONTAIN_SPACE))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createAmountToQuantity(NUMBERS_CONTAIN_SPECIAL_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);

        assertThatThrownBy(()->numberGenerator.createAmountToQuantity(null))
                .isInstanceOf(IllegalNullTypeException.class);
    }
    @DisplayName("보너스 번호를 반환한다")
    @Test
    void createBonusNumberFromConsole() {
        Integer bonusNumber = numberGenerator.createBonusNumberFromConsole(BONUS_NUMBER);
        assertThat(bonusNumber).isEqualTo(Integer.valueOf(BONUS_NUMBER));
    }

    @DisplayName("1-45 사이의 번호가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberFromConsoleOverValueException() {
        assertThatThrownBy(()->numberGenerator.createBonusNumberFromConsole(BONUS_NUMBER_OVER))
                .isInstanceOf(IllegalOverValueException.class);
    }

    @DisplayName("문자, 공백, 특수문자, null 포함시 예외가 발생한다.")
    @Test
    void createBonusNumberFromConsoleException() {
        assertThatThrownBy(()->numberGenerator.createBonusNumberFromConsole(NUMBERS_CONTAIN_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createBonusNumberFromConsole(NUMBERS_CONTAIN_SPACE))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->numberGenerator.createBonusNumberFromConsole(NUMBERS_CONTAIN_SPECIAL_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);

        assertThatThrownBy(()->numberGenerator.createBonusNumberFromConsole(null))
                .isInstanceOf(IllegalNullTypeException.class);
    }
}