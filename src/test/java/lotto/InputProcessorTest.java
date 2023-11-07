package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력 유효성 테스트")
class InputProcessorTest {

    @DisplayName("성공: 입력 금액 파싱")
    @Test
    void test1() {
        String input = "1000";
        assertThatCode(() -> InputProcessor.parsePrice(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("실패: 일반 문자열에 대해 에러 처리 가능")
    @Test
    void test2() {
        String input = "ㅁㄴㅇㄹ";
        assertThatCode(() -> InputProcessor.parsePrice(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(CustomErrorMessage.NUMBER_FORMAT);
    }

    @DisplayName("실패: 빈칸에 대해 에러 처리 가능")
    @Test
    void test3() {
        String input = " ";
        assertThatCode(() -> InputProcessor.parsePrice(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(CustomErrorMessage.NUMBER_FORMAT);
    }

    @DisplayName("실패: 공백에 대해 에러 처리 가능")
    @Test
    void test4() {
        String input = "";
        assertThatCode(() -> InputProcessor.parsePrice(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(CustomErrorMessage.NUMBER_FORMAT);
    }

    @DisplayName("실패: 유효하지 않은 금액에 대해 에러 처리 가능")
    @Test
    void test5() {
        int input = -1000;
        assertThatCode(() -> InputProcessor.checkPriceValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessage.PRICE_VALID);
    }
}