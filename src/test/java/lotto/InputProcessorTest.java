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

    @DisplayName("실패: 잘못된 양식에 대한 에러 처리 가능")
    @Test
    void test6() {
        String input = "r,r,r,r,r";
        assertThatCode(() -> InputProcessor.getWinningNumbers(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(CustomErrorMessage.NUMBER_FORMAT);
    }

    @DisplayName("실패: 공백과 같은 에러 처리 가능")
    @Test
    void test7() {
        String input = "r,r ,  r,r ,r";
        assertThatCode(() -> InputProcessor.getWinningNumbers(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(CustomErrorMessage.NUMBER_FORMAT);
    }

    @DisplayName("성공: 당첨 번호를 입력할 수 있다.")
    @Test
    void test8() {
        String input = "1,2,3,4,5,6";
        assertThatCode(() -> InputProcessor.getWinningNumbers(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("실패: 잘못된 입력에 대해서 에러를 출력할 수 있다.(공백)")
    @Test
    void test9() {
        String input = "";
        assertThatCode(() -> InputProcessor.getBonusNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(CustomErrorMessage.NUMBER_FORMAT);
    }

    @DisplayName("실패: 잘못된 입력에 대해서 에러를 출력할 수 있다.(빈칸)")
    @Test
    void test10() {
        String input = " ";
        assertThatCode(() -> InputProcessor.getBonusNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(CustomErrorMessage.NUMBER_FORMAT);
    }

    @DisplayName("실패: 잘못된 입력에 대해서 에러를 출력할 수 있다.(문자열)")
    @Test
    void test11() {
        String input = " ㄴㅁㄻㄴㅁ";
        assertThatCode(() -> InputProcessor.getBonusNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(CustomErrorMessage.NUMBER_FORMAT);
    }
}