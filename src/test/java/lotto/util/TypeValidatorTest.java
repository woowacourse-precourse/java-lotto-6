package lotto.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TypeValidatorTest {

    @Test
    @DisplayName("양의 정수인 경우")
    void validatePositiveInteger_양의_정수() {
        TypeValidator.validatePositiveInteger(3);
    }

    @Test
    @DisplayName("음의 정수인 경우")
    void validatePositiveInteger_음의_정수() {
        assertThrows(IllegalStateException.class, () -> {
            TypeValidator.validatePositiveInteger(-4);
        });
    }

    @Test
    @DisplayName("0인 경우")
    void validatePositiveInteger_0() {
        assertThrows(IllegalStateException.class, () -> {
            TypeValidator.validatePositiveInteger(0);
        });
    }

    @Test
    @DisplayName("양의 정수 리스트인 경우")
    void validatePositiveIntegerList_양의_정수_리스트() {
        TypeValidator.validatePositiveIntegerList(List.of(1, 2, 3, 4));
    }

    @Test
    @DisplayName("양의 정수 리스트가 아닌 경우")
    void validatePositiveIntegerList_양의_정수_리스트_아님() {
        assertThrows(IllegalStateException.class, () -> {
            TypeValidator.validatePositiveIntegerList(List.of(1, 2, -3, 4, 5));
        });
    }
}