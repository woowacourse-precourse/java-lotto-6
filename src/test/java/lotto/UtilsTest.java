package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.Utils;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    void splitByComma_문자열을_쉼표_기준으로_분할_테스트() {
        assertThat(Utils.splitByComma("1,2,3,4,5,6")).isEqualTo(List.of("1","2","3","4","5","6"));
    }

    @Test
    void removeSpace_공백을_제거해주는지_테스트() {
        assertThat(Utils.removeSpace("1,  2,   3,  4,  5,  6")).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    void parseInt_숫자반환_테스트() {
        assertThat(Utils.parseInt("123")).isEqualTo(123);
    }

    @Test
    void validateStringIsNumber_숫자_아니면_예외반환() {
        assertThatThrownBy(() -> Utils.validateStringIsNumber("abc")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateHasInput_공백_이면_예외반환() {
        assertThatThrownBy(() -> Utils.validateHasInput(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateHasInput_null_이면_예외반환() {
        assertThatThrownBy(() -> Utils.validateHasInput(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
