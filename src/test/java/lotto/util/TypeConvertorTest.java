package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TypeConvertorTest {

    @Test
    @DisplayName("유효한 문자열을 정수로 변환한다")
    void stringToInt() {
        // When
        Integer result = TypeConvertor.stringToInt("42");

        // Then
        assertThat(result).isEqualTo(42);
    }

    @Test
    @DisplayName("유효하지 않은 문자열을 정수로 변환할 때 예외를 던진다")
    void stringToIntWithInvalidInput() {
        // When, Then
        assertThatThrownBy(() -> TypeConvertor.stringToInt("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효한 문자열을 long으로 변환한다")
    void stringToLong() {
        // When
        Long result = TypeConvertor.stringToLong("1234567890");

        // Then
        assertThat(result).isEqualTo(1234567890L);
    }

    @Test
    @DisplayName("유효하지 않은 문자열을 long으로 변환할 때 예외를 던진다")
    void stringToLongWithInvalidInput() {
        // When, Then
        assertThatThrownBy(() -> TypeConvertor.stringToLong("123.45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효한 문자열 목록을 정수 목록으로 변환한다")
    void stringToStringList() {
        // When
        List<Integer> result = TypeConvertor.stringToStringList("1, 2, 3, 4, 5");

        // Then
        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("유효하지 않은 문자열 목록을 정수 목록으로 변환할 때 예외를 던진다")
    void stringToStringListWithInvalidInput() {
        // When, Then
        assertThatThrownBy(() -> TypeConvertor.stringToStringList("1, 2, abc, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
