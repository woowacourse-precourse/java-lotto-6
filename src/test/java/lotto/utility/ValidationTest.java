package lotto.utility;

import lotto.domain.Lotto;
import lotto.utility.enums.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    // 1. 로또 구입금액 입력시 예외처리
    @DisplayName("사용자 입력금액이 없는 경우")
    @Test
    void createPurchaseAmountNoInput() {
        assertThatThrownBy(() -> Validation.vaildatePurchaseAmount(""))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ExceptionMessages.IS_EMPTY.getMessage());
    }

    @DisplayName("사용자 입력금액이 숫자가 아닌 경우")
    @Test
    void createPurchaseAmountNotNumber() {
        assertThatThrownBy(() -> Validation.vaildatePurchaseAmount("jun"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ExceptionMessages.NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("사용자 입력금액이 1000원 단위가 아닌 경우")
    @Test
    void createPurchaseAmountNotDivisibleByThousand() {
        assertThatThrownBy(() -> Validation.vaildatePurchaseAmount("23100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
    }

    // 2. 당첨 번호 입력시 예외처리
    @DisplayName("사용자 입력 당첨 번호에 숫자 및 컴마 외의 문자가 포함되어 있는 경우")
    @Test
    void createWinningNumbersContainCharExceptCommaAndNumber(){
        assertThatThrownBy(() -> Validation.vaildateWinningNumbers("10,20,30,40,41,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NOT_NUMBERS_AND_COMMA.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {",10,20,30,40,41,42", "10,20,30,40,41,42,", "10,20,30,,40,41,42"})
    @DisplayName("사용자 입력 당첨 번호에 컴마 위치가 올바르지 않은 경우")
    void createWinningNumbersWithImproperCommaPosition(String winningNumbers){
        assertThatThrownBy(() -> Validation.vaildateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NOT_PROPER_COMMA_POSITION.getMessage());
    }

    @DisplayName("사용자 입력 당첨 번호에 컴마가 5개가 아닌 경우. 즉, 당첨 숫자가 6개가 아닌 경우")
    @Test
    void createWinningNumbersWithSixComma(){
        assertThatThrownBy(() -> Validation.vaildateWinningNumbers("10,20,30,40,41,42,45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INCORRECT_NUMBER_COUNT.getMessage());
    }

    @DisplayName("사용자 입력 당첨 번호에 중복 값이 있는 경우")
    @Test
    void createWinningNumbersWithDuplicateNumbers(){
        assertThatThrownBy(() -> Validation.vaildateWinningNumbers("10,20,30,30,41,42"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.IS_DUPLICATE_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,20,30,40,41,42", "10,20,30,40,41,100"})
    @DisplayName("사용자 입력 당첨 번호가 1과 45 사이의 정수가 아닌 경우")
    void createWinningNumbersOutOfNumberRange(String winningNumbers){
        assertThatThrownBy(() -> Validation.vaildateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.OUT_OF_NUMBER_RANGE.getMessage());
    }
}
