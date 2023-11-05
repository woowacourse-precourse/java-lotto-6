package lotto.service;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNumbersValidatorTest {
    @DisplayName("유저 로또 번호 입력 정상 테스트")
    @Test
    void testPreChangeUserNumbers() {
        assertThat(UserNumbersValidator.preValidate("1,2,3,4,5,6")).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("유저 로또 번호 입력 정상 테스트")
    @Test
    void testPostChangeUserNumbers() {
        assertThat(UserNumbersValidator.postValidate(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("유저 로또 번호 입력 문자 예외 테스트")
    @Test
    void testPreChangeUserNumbersException() {
        assertThatThrownBy(() -> UserNumbersValidator.preValidate("1,2,3,4,5,6a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 문자 예외 테스트")
    @Test
    void testPreChangeUserNumbersException2() {
        assertThatThrownBy(() -> UserNumbersValidator.preValidate("1,2,3,4,5,6ㅁ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 문자 예외 테스트")
    @Test
    void testPreChangeUserNumbersException3() {
        assertThatThrownBy(() -> UserNumbersValidator.preValidate("1,2,3,4,5,6|"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 사이즈 예외 테스트")
    @Test
    void testPostChangeUserNumbersException() {
        assertThatThrownBy(() -> UserNumbersValidator.postValidate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 중복 예외 테스트")
    @Test
    void testByDuplication() {
        assertThatThrownBy(() -> UserNumbersValidator.postValidate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 최대 예외 테스트")
    @Test
    void testByMaxvalue() {
        assertThatThrownBy(() -> UserNumbersValidator.postValidate(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 최소 예외 테스트")
    @Test
    void testByMinvalue() {
        assertThatThrownBy(() -> UserNumbersValidator.postValidate(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 구분자 시작 예외 테스트")
    @Test
    void errorByStartDelimiter() {
        assertThatThrownBy(() -> UserNumbersValidator.preValidate(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 구분자 끝 예외 테스트")
    @Test
    void errorByEndDelimiter() {
        assertThatThrownBy(() -> UserNumbersValidator.preValidate("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유저 로또 번호 입력 구분자 중복 예외 테스트")
    @Test
    void errorByDuplicationDelimiter() {
        assertThatThrownBy(() -> UserNumbersValidator.preValidate("1,2,3,4,5,,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
