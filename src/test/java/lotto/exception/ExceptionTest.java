package lotto.exception;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ExceptionTest {
    private Exception exception;

    @BeforeEach
    void setUp() {
        exception = new Exception();
    }

    @DisplayName("양수 문자열 입력시 정상적으로 int 변환한다.")
    @Test
    void 인트_변환_양수_입력() {
        int result = exception.checkInt("1000");
        assertThat(result).isEqualTo(1000);
    }

    @DisplayName("음수 문자열 입력시 정상적으로 int 변환한다.")
    @Test
    void 인트_변환_음수_입력() {
        int result = exception.checkInt("-1000");
        assertThat(result).isEqualTo(-1000);
    }

    @DisplayName("숫자가 아닌 문자열 입력시 0 반환한다.")
    @Test
    void 인트_변환_문자_입력() {
        int result = exception.checkInt("test");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("1000 단위 입력시 true 반환한다.")
    @Test
    void 단위1000_올바른_입력() {
        boolean result = exception.checkAmount(2000, false);
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("1000 단위가 아닐시 false 반환한다.")
    @Test
    void 단위1000_잘못된_입력() {
        boolean result = exception.checkAmount(2222, false);
        assertThat(result).isEqualTo(false);
    }

    @DisplayName("중복 없는 6자리일 경우 그대로 반환한다.")
    @Test
    void 중복_없는_숫자_6개() {
        List<Integer> result = exception.checkNumbers("1,2,3,4,5,6");
        assertThat(result).isEqualTo(result);
    }

    @DisplayName("중복 확인되면 바로 반환한다.")
    @Test
    void 중복_있는_숫자_6개() {
        List<Integer> result = exception.checkNumbers("1,2,3,4,4,5");
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4));
    }

    @DisplayName("중복 없는 숫자일 경우 그대로 반환한다.")
    @Test
    void 중복_없는_보너스_숫자_1개() {
        int result = exception.checkBonus(List.of(2, 3, 4, 5, 6), "1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("중복 확인되면 0을 반환한다.")
    @Test
    void 중복_있는_보너스_숫자_1개() {
        int result = exception.checkBonus(List.of(1, 2, 3, 4, 5), "1");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("ㅁㅁㅁ")
    @Test
    void ㅁㅁㅁ() {
        assertThatCode(() -> exception.throwIllegalArgument("123"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}