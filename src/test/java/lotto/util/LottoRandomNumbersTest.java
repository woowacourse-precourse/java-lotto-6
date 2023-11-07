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
        //given
        //when
        List<Integer> randomNumbers = LottoRandomNumbers.getRandomNumbers();

        //then
        for (int number : randomNumbers) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("사이즈가 6인 숫자 리스트가 생성된다.")
    void When_GetRandomNumbers_Then_HasSize6() {
        //given
        //when
        List<Integer> randomNumbers = LottoRandomNumbers.getRandomNumbers();

        //then
        assertThat(randomNumbers).hasSize(6);
    }

    @Test
    @DisplayName("각각의 숫자가 중복되지 않는 숫자 리스트가 생성된다.")
    void Given_GetRandomNumbers_When_DeleteDuplicateNumber_Then_CountEqual6() {
        //given
        List<Integer> randomNumbers = LottoRandomNumbers.getRandomNumbers();

        //when
        long actualCount = randomNumbers.stream()
                .distinct()
                .count();

        //then
        assertThat(actualCount).isEqualTo(6);
    }
}
