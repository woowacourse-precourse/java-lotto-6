package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {

    Parser parser = new Parser();

    @DisplayName("로또 구입 금액이 비어있으면 예외를 발생시킨다.")
    @Test
    void 로또_구입금액_빈값() {
        assertThatThrownBy(() -> parser.checkEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 문자값이면 예외를 발생시킨다.")
    @Test
    void 로또_구입금액_문자() {
        assertThatThrownBy(() -> parser.checkDigit("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 문자값이면 예외를 발생시킨다.")
    @Test
    void 로또_구입금액_1000원단위_아님() {
        assertThatThrownBy(() -> parser.checkThousand(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
