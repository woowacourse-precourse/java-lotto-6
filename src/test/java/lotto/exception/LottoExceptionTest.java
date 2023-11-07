package lotto.exception;

import static lotto.exception.LottoException.DUPLICATED_BONUS_NUMBER;
import static lotto.exception.LottoException.DUPLICATED_LOTTO_NUMBER;
import static lotto.exception.LottoException.LESS_THAN_MINIMUM_LOTTO_NUMBER;
import static lotto.exception.LottoException.LESS_THAN_MINIMUM_PURCHASE_AMOUNT;
import static lotto.exception.LottoException.MORE_THAN_MAXIMUM_LOTTO_NUMBER;
import static lotto.exception.LottoException.MORE_THAN_MAXIMUM_PURCHASE_AMOUNT;
import static lotto.exception.LottoException.NOT_VALID_LOTTO_NUMBERS_SIZE;
import static lotto.exception.LottoException.NOT_VALID_PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoExceptionTest {
    @DisplayName("로또 번호의 개수가 6개가 아니라면 예외 메시지를 반환한다.")
    @Test
    void testNotValidLottoNumbersException() {
        //when, then
        assertThatThrownBy(() -> NOT_VALID_LOTTO_NUMBERS_SIZE.throwException())
                .hasMessage(NOT_VALID_LOTTO_NUMBERS_SIZE.getMessage());
    }

    @DisplayName("로또 번호가 1보다 작다면 예외 메시지를 반환한다.")
    @Test
    void testLessThanMinimumLottoNumberException() {
        //when, then
        assertThatThrownBy(() -> LESS_THAN_MINIMUM_LOTTO_NUMBER.throwException())
                .hasMessage(LESS_THAN_MINIMUM_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 45보다 크다면 예외 메시지를 반환한다.")
    @Test
    void testMoreThanMaximumException() {
        //when, then
        assertThatThrownBy(() -> MORE_THAN_MAXIMUM_LOTTO_NUMBER.throwException())
                .hasMessage(MORE_THAN_MAXIMUM_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호중 중복된 번호가 있다면 예외 메시지를 반환한다.")
    @Test
    void testDuplicatedLottoNumberException() {
        //when, then
        assertThatThrownBy(() -> DUPLICATED_LOTTO_NUMBER.throwException())
                .hasMessage(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된다면 예외 메시지를 반환한다.")
    @Test
    void testDuplicatedBonusNumberException() {
        //when, then
        assertThatThrownBy(() -> DUPLICATED_BONUS_NUMBER.throwException())
                .hasMessage(DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니라면 예외 메시지를 반환한다.")
    @Test
    void testNotValidPurchaseAmountUnitException() {
        //when, then
        assertThatThrownBy(() -> NOT_VALID_PURCHASE_AMOUNT_UNIT.throwException())
                .hasMessage(NOT_VALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }

    @DisplayName("구입 금액이 1,000원보다 적다면 예외 메시지를 반환한다.")
    @Test
    void testLessThanMinimumPurchaseAmountException() {
        //when, then
        assertThatThrownBy(() -> LESS_THAN_MINIMUM_PURCHASE_AMOUNT.throwException())
                .hasMessage(LESS_THAN_MINIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("구입 금액이 20,000원보다 많다면 예외 메시지를 반환한다.")
    @Test
    void testMoreThanMaximumPurchaseAmountException() {
        //when, then
        assertThatThrownBy(() -> MORE_THAN_MAXIMUM_PURCHASE_AMOUNT.throwException())
                .hasMessage(MORE_THAN_MAXIMUM_PURCHASE_AMOUNT.getMessage());
    }
}
