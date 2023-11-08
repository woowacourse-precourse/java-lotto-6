package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 랜덤 숫자를 생성하는 객체에 대해")
class LottoRandomNumbersTest {

    @Test
    @DisplayName("1 부터 45 사이의 숫자 리스트가 생성된다.")
    void When_GetRandomNumbers_Then_IncludeRange() {
        //when
        List<Integer> actualValues = LottoRandomNumbers.getRandomNumbers();

        //then
        for (int actual : actualValues) {
            assertThat(actual).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("사이즈가 6인 숫자 리스트가 생성된다.")
    void When_GetRandomNumbers_Then_HasSize6() {
        //when
        List<Integer> actualValues = LottoRandomNumbers.getRandomNumbers();

        //then
        assertThat(actualValues).hasSize(6);
    }

    @Test
    @DisplayName("각각의 숫자가 중복되지 않는 숫자 리스트가 생성된다.")
    void Given_GetRandomNumbers_When_DeleteDuplicateNumber_Then_CountEqual6() {
        //given
        List<Integer> actualValues = LottoRandomNumbers.getRandomNumbers();

        //when
        long actual = actualValues.stream()
                .distinct()
                .count();

        //then
        assertThat(actual).isEqualTo(6);
    }
}
