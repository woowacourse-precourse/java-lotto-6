package lotto.util;

import static lotto.util.TestUtil.ERROR_PREFACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.NonNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @DisplayName("원 단위로 변환이 잘 되는지 확인한다.")
    @Test
    void conversionWon() {
        String wonTypeText = Utils.conversionWon(1000);
        assertThat(wonTypeText).isEqualTo("1,000");
    }

    @DisplayName("숫자 문자열이면 변환된다.")
    @Test
    void conversionInt() {
        int number = Utils.conversionInt("123");
        assertThat(number).isEqualTo(123);
    }

    @DisplayName("숫자가 아니면 예외가 발생한다.")
    @Test
    void conversionIntThrowCase1() {
        assertThatThrownBy(() -> Utils.conversionInt("일이삼자"))
                .isInstanceOf(NonNumberException.class)
                .hasMessageContaining(ERROR_PREFACE);
    }
}