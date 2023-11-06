package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoAnswerTest {

    @Test
    @DisplayName("당첨번호가 정수가 아니면 예외가 발생한다.")
    void testParseInteger() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoAnswer lottoAnswer = new LottoAnswer("1,2,a,b,5,6");
        });

        assertDoesNotThrow(() -> {
            LottoAnswer lottoAnswer = new LottoAnswer("1,2,3,4,5,6");
        });
    }

    @Test
    @DisplayName("당첨번호가 6자리가 아니면 예외가 발생한다.")
    void testCheckLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoAnswer lottoAnswer = new LottoAnswer("1,2,3,4,5");
        });

        assertDoesNotThrow(() -> {
            LottoAnswer lottoAnswer = new LottoAnswer("1,2,3,4,5,6");
        });
    }

    @Test
    @DisplayName("당첨번호가 1 <= x <= 45 범위에 없으면 예외가 발생한다.")
    void testIsInRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoAnswer lottoAnswer = new LottoAnswer("-1,2,3,4,5,6");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LottoAnswer lottoAnswer = new LottoAnswer("1,2,3,4,5,99");
        });
    }
}