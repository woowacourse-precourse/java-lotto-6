package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

class ErrorMessageTest {

    @Test
    void 구매금액_숫자_예외문구_테스트() {
        String expectedMessage = PURCHASE_AMOUNT_CONVERT_EXCEPTION.getMessage();

        assertThat(PURCHASE_AMOUNT_CONVERT_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 구매금액_천단위_예외문구_테스트() {
        String expectedMessage = PURCHASE_AMOUNT_THOUSAND_EXCEPTION.getMessage();

        assertThat(PURCHASE_AMOUNT_THOUSAND_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 구매금액_최대값_예외문구_테스트() {
        String maxValue = "100000";
        String expectedMessage = PURCHASE_AMOUNT_MAXVALUE_EXCEPTION.getMessage().replace("MAX_VALUE", maxValue);

        assertThat(PURCHASE_AMOUNT_MAXVALUE_EXCEPTION.getMaxValueMessage(maxValue))
                .isEqualTo(expectedMessage);
    }

    @Test
    void 구매금익_최대값_예외테스트1() {
        String expectedMessage = PURCHASE_AMOUNT_CONVERT_EXCEPTION.getMessage();
        String maxValue = "100000";

        assertThat(PURCHASE_AMOUNT_CONVERT_EXCEPTION.getMaxValueMessage(maxValue))
                .isEqualTo(expectedMessage);
    }

    @Test
    void 구매금익_최대값_예외테스트2() {
        String expectedMessage = PURCHASE_AMOUNT_THOUSAND_EXCEPTION.getMessage();
        String maxValue = "100000";

        assertThat(PURCHASE_AMOUNT_THOUSAND_EXCEPTION.getMaxValueMessage(maxValue))
                .isEqualTo(expectedMessage);
    }

    @Test
    void 당첨번호_6글자입력_예외문구_테스트() {
        String expectedMessage = WINNING_NUMBER_SIX_EXCEPTION.getMessage();

        assertThat(WINNING_NUMBER_SIX_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 당첨번호_숫자_예외문구_테스트() {
        String expectedMessage = WINNING_NUMBER_CONVERT_EXCEPTION.getMessage();

        assertThat(WINNING_NUMBER_CONVERT_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 당첨번호_숫자범위_예외문구_테스트() {
        String expectedMessage = WINNING_NUMBER_RANGE_EXCEPTION.getMessage();

        assertThat(WINNING_NUMBER_RANGE_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 당첨번호_숫자중복_예외문구_테스트() {
        String expectedMessage = WINNING_NUMBER_DUPLICATE_EXCEPTION.getMessage();

        assertThat(WINNING_NUMBER_DUPLICATE_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 보너스번호_숫자_예외문구_테스트() {
        String expectedMessage = BONUS_NUMBER_CONVERT_EXCEPTION.getMessage();

        assertThat(BONUS_NUMBER_CONVERT_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 보너스번호_숫자범위_예외문구_테스트() {
        String expectedMessage = BONUS_NUMBER_RANGE_EXCEPTION.getMessage();

        assertThat(BONUS_NUMBER_RANGE_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 보너스번호_숫자중복_예외문구_테스트() {
        String expectedMessage = BONUS_NUMBER_DUPLICATE_EXCEPTION.getMessage();

        assertThat(BONUS_NUMBER_DUPLICATE_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 로또번호_6자리_예외문구_테스트() {
        String expectedMessage = LOTTO_NUMBER_SIX_EXCEPTION.getMessage();

        assertThat(LOTTO_NUMBER_SIX_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }

    @Test
    void 로또번호_숫자중복_예외문구_테스트() {
        String expectedMessage = LOTTO_NUMBER_DUPLICATE_EXCEPTION.getMessage();

        assertThat(LOTTO_NUMBER_DUPLICATE_EXCEPTION.getMessage())
                .isEqualTo(expectedMessage);
    }
}