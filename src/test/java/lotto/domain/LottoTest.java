package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class LottoTest {

    @DisplayName("수동 당첨 번호 객체 생성 테스트")
    @Test
    void createLotto() {
        // Arrange
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // Act
        Lotto lotto = new Lotto(numbers);

        // Assert
        Assertions.assertIterableEquals(numbers, lotto.getNumbers());
        Assertions.assertEquals(numbers.size(), lotto.getNumbers().size());
    }
}