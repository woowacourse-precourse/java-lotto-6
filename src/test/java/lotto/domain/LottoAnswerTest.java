package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    @DisplayName("BonusNumber 의 생성 테스트")
    void testGetBonusNumber() {
        LottoAnswer lottoAnswer = new LottoAnswer("1,2,3,4,5,6", 7);
        BonusNumber bonusNumber = lottoAnswer.getBonusNumber();
        assertNotNull(bonusNumber);
        assertEquals(7, bonusNumber.getNumber());
    }

    @Test
    @DisplayName("BonusNumber 의 존재 유무 테스트")
    void testHasBonusNumber() {
        LottoAnswer lottoAnswer1 = new LottoAnswer("1,2,3,4,5,6", 7);
        assertTrue(lottoAnswer1.hasBonusNumber());

        LottoAnswer lottoAnswer2 = new LottoAnswer("1,2,3,4,5,6");
        assertFalse(lottoAnswer2.hasBonusNumber());
    }

    @Test
    @DisplayName("BonusNumber 가 중복될 경우 에러가 발생한다.")
    void testIsUnique() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}