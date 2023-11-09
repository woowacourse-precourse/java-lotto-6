package lotto.core.lottoBall.domain;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.core.lottoBall.exception.InvalidLottoBallRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallTest {

    @Test
    @DisplayName("로또 볼 생성 한다.")
    void create() {
        // given
        Integer number = 1;

        // when
        LottoBall lottoBall = new LottoBall(number);

        // then
        assertInstanceOf(LottoBall.class, lottoBall);
    }

    @Test
    @DisplayName("1보다 작은 수의 로또 볼을 만들 수 없다.")
    void canNotCreatLessThanMINLottoBall() {
        // given
        Integer number = 0;

        // when & then
        assertThrows(InvalidLottoBallRangeException.class, () -> {
            new LottoBall(number);
        });
    }

    @Test
    @DisplayName("45보다 큰 수의 로또 볼을 만들 수 없다.")
    void canNotCreatMoreThanMAXLottoBall() {
        // given
        Integer number = 46;

        // when & then
        assertThrows(InvalidLottoBallRangeException.class, () -> {
            new LottoBall(number);
        });
    }

    @Test
    @DisplayName("로또 볼이 같은지 확인 한다.")
    void isMatch() {
        // given
        Integer number = 1;
        LottoBall lottoBall = new LottoBall(number);

        // when
        boolean result = lottoBall.match(number);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("로또 볼이 다른지 확인")
    void isNotMatch() {
        // given
        Integer source = 1;
        LottoBall sourceBall = new LottoBall(source);
        Integer target = 2;

        // when
        boolean result = sourceBall.match(target);

        // then
        assertFalse(result);
    }
}