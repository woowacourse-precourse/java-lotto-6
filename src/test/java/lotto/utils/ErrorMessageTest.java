package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorMessageTest {

    @DisplayName("에러 메시지를 가져올 때 '[ERROR]' 를 붙여서 가져온다.")
    @Test
    void getWithPrefix() {
        // given
        String expectedResult = "[ERROR] 입력이 정수가 아닙니다.";
        // when, then
        assertThat(ErrorMessage.NOT_INTEGER_INPUT.getWithPrefix())
                .isEqualTo(expectedResult);
    }

    @DisplayName("'[ERROR] '를 붙이고, 한 개의 매개 변수에 따른 format에 맞게 에러 메시지를 가져온다.")
    @Test
    void getWithFormatAndPrefix() {
        // given
        String expectedResult = "[ERROR] 최대로 구입 가능한 로또 개수는 100개 입니다. 구입 금액을 낮춰주세요.";
        // when, then
        assertThat(ErrorMessage.TOO_MUCH_PURCHASE_AMOUNT.getWithFormatAndPrefix(100))
                .isEqualTo(expectedResult);

    }

    @DisplayName("'[ERROR] '를 붙이고, 두 개의 메개 변수에 따른 format에 맞게 에러 메시지를 가져온다.")
    @Test
    void getWithTwoParameterFormatAndPrefix() {
        // given
        String expectedResult = "[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다.";
        // when, then
        assertThat(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getWithFormatAndPrefix(1, 45))
                .isEqualTo(expectedResult);
    }
}