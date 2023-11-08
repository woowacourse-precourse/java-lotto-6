package lotto.domain.result;

import lotto.domain.prize.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @Test
    @DisplayName("결과는 정상적으로 생성되어야 한다.")
    void 결과_정상_생성() {
        Result result = new Result(1, true);

        assertEquals(1, result.count());
        assertTrue(result.isBonus());
    }

    @Test
    @DisplayName("결과는 정상적으로 생성되어야 한다.")
    void 결과_정상_생성_보너스false() {
        Result result = new Result(100, false);

        assertEquals(100, result.count());
        assertFalse(result.isBonus());
    }

    @Test
    @DisplayName("결과는 자신의 등급을 반환할 수 있어야 한다.")
    void 결과_반환_1등() {
        Result result = new Result(6, false);

        assertEquals(Prize.FIRST, result.substitutePrize());
    }

    @Test
    @DisplayName("결과는 자신의 등급을 반환할 수 있어야 한다.")
    void 결과_반환_2등() {
        Result result = new Result(5, true);

        assertEquals(Prize.SECOND, result.substitutePrize());
    }

    @Test
    @DisplayName("결과는 자신의 등급을 반환할 수 있어야 한다.")
    void 결과_반환_3등() {
        Result result = new Result(5, false);

        assertEquals(Prize.THIRD, result.substitutePrize());
    }

    @Test
    @DisplayName("결과는 자신의 등급을 반환할 수 있어야 한다.")
    void 결과_반환_4등() {
        Result result = new Result(4, false);

        assertEquals(Prize.FOURTH, result.substitutePrize());
    }

    @Test
    @DisplayName("결과는 자신의 등급을 반환할 수 있어야 한다.")
    void 결과_반환_5등() {
        Result result = new Result(3, false);

        assertEquals(Prize.FIFTH, result.substitutePrize());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("결과는 자신의 등급을 반환할 수 있어야 한다.")
    void 결과_반환_6등(int count) {
        Result result = new Result(count, false);

        assertEquals(Prize.NONE, result.substitutePrize());
    }
}