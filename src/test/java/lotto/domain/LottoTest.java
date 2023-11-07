package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import lotto.common.Constant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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


    @DisplayName("수동 당첨 번호가 1 ~ 45 사이의 수가 아니면 IllegalArgumentException 예외 발생")
    @ParameterizedTest()
    @MethodSource("getNumberLists")
    void createLottoByInvalidNumber(List<Integer> numbers) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    private static Stream<Arguments> getNumberLists() {
        return Stream.of(
            Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
            Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }

    @DisplayName("자동 로또 번호 랜덤 생성 객체 테스트")
    @Test
    void createAutomaticLotto() {
        // Arrange
        Lotto lotto = new Lotto();

        // Assert
        Assertions.assertEquals(Constant.LOTTO_NUM_SIZE, lotto.getNumbers().size());
    }
}