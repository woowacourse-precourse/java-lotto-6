package lotto.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("숫자가 아닌 문자열 입력시 IllegalArgumentException과 에러 메시지를 반환한다.")
    @Test
    void 인트_변환_문자_입력() {
        assertThatThrownBy(() ->  exception.checkInt("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000 단위 입력시 true 반환한다.")
    @Test
    void 단위1000_올바른_입력() {
        boolean result = exception.checkAmount(2000, false, "오류!");
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("1000 단위가 아닐시 IllegalArgumentException과 에러 메시지를 반환한다.")
    @Test
    void 단위1000_잘못된_입력() {
        assertThatThrownBy(() ->  exception.checkAmount(2222, false, "오류!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 없는 6자리일 경우 그대로 반환한다.")
    @Test
    void 중복_없는_숫자_6개() {
        List<Integer> result = exception.checkNumbers("1,2,3,4,5,6");
        assertThat(result).isEqualTo(result);
    }

    @DisplayName("중복 확인되면 바로 반환하며 IllegalArgumentException과 에러 메시지를 출력한다.")
    @Test
    void 중복_있는_숫자_6개() {
        assertThatThrownBy(() ->  exception.checkNumbers("1,2,3,4,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6자리 숫자일 경우 그대로 반환한다.")
    @Test
    void 길이_6자리() {
        List<Integer> result = exception.checkLength(List.of(1, 2, 3, 4, 5, 6));
        assertThat(result).isEqualTo(result);
    }

    @DisplayName("6자리 숫자가 아닐 경우 그대로 반환하며 IllegalArgumentException과 에러 메시지를 출력한다.")
    @Test
    void 길이_6자리_초과() {
        assertThatThrownBy(() ->  exception.checkLength(List.of(1, 2, 3, 4, 5, 6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 없는 숫자일 경우 그대로 반환한다.")
    @Test
    void 중복_없는_보너스_숫자_1개() {
        int result = exception.checkBonus(List.of(2, 3, 4, 5, 6), "1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("중복 확인되면 IllegalArgumentException과 에러 메시지를 반환한다.")
    @Test
    void 중복_있는_보너스_숫자_1개() {
        assertThatThrownBy(() ->  exception.checkBonus(List.of(1, 2, 3, 4, 5), "1"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}