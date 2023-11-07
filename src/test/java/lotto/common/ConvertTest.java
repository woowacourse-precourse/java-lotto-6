package lotto.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertTest {
    private static final String NON_INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 합니다(공백 미포함)";
    @Test
    @DisplayName("공백이 포함된 문자가 들어올 경우 예외가 발생한다.")
    void 정수변환_공백_Test() throws Exception {
        //given
        String string = "1000 ";
        //when

        //then
        assertThatThrownBy(() -> Convert.stringToInteger(string))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Convert.stringToInteger(string);
        });
        assertThat(exception.getMessage()).isEqualTo(NON_INTEGER_INPUT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함된 문자가 들어올 경우 예외가 발생한다.")
    void 정수변환_문자_Test() throws Exception {
        //given
        String string = "1000!";
        //when

        //then
        assertThatThrownBy(() -> Convert.stringToInteger(string))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Convert.stringToInteger(string);
        });
        assertThat(exception.getMessage()).isEqualTo(NON_INTEGER_INPUT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("콤마로 분리할 경우, 공백이 포함될 경우 예외가 발생한다.")
    void 콤마분리_공백_Test() throws Exception {
        //given
        String string = "1,2, 3, 4, 5, 6";
        //when

        //then
        assertThatThrownBy(() -> Convert.splitByComma(string))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Convert.splitByComma(string);
        });
        assertThat(exception.getMessage()).isEqualTo(NON_INTEGER_INPUT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("콤마로 분리할 경우, 숫자가 아닌 문자가 포함될 경우 예외가 발생한다.")
    void 콤마분리_문자_Test() throws Exception {
        //given
        String string = "1,2,3,4,ㄱ,5";
        //when

        //then
        assertThatThrownBy(() -> Convert.splitByComma(string))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            Convert.splitByComma(string);
        });
        assertThat(exception.getMessage()).isEqualTo(NON_INTEGER_INPUT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("수익률은 XXX,XXX.X의 형태가 되어야한다.")
    void 수익률_포메팅() throws Exception {
        //given
        double revenuRate1 = 10.0;
        double revenuRate2 = 0.1;
        double revenuRate3 = 10000000.0;
        //when
        String result1 = Convert.formatWithCommaAndRound(revenuRate1);
        String result2 = Convert.formatWithCommaAndRound(revenuRate2);
        String result3 = Convert.formatWithCommaAndRound(revenuRate3);
        //then
        assertThat(result1).isEqualTo("10.0");
        assertThat(result2).isEqualTo("0.1");
        assertThat(result3).isEqualTo("10,000,000.0");
    }
}