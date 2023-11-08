package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest {

    @DisplayName("로또 번호는 1 ~ 45 사이 숫자이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 43, 44, 45 })
    void validateNumberList(int number) {
        // Arrange & Act
        boolean result = LottoNumberValidator.validate(number);

        // Assert
        Assertions.assertEquals(true, result);
    }
}