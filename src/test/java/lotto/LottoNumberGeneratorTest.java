package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.GameConfig.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("unique한 값만을 포함한다.")
    void uniquenessTest() {
        //given
        //when
        List<Integer> result = LottoNumberGenerator.generateRandomLottoNumber();

        //then
        assertThat(result).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("지정한 개수의 원소를 포함한다.")
    void numberOfElementTest() {
        //given
        int expectedNumber = 6;
        //when
        List<Integer> result = LottoNumberGenerator.generateRandomLottoNumber();
        //then
        assertThat(result)
                .hasSize(expectedNumber);
    }

    @Test
    @DisplayName("지정한 범위 내의 수만을 포함한다.")
    void numberRangeTest() {
        //given
        //when
        List<Integer> result = LottoNumberGenerator.generateRandomLottoNumber();
        //then
        assertThat(result)
                .allMatch(t -> t >= LOTTO_NUMBER_LOWER_BOUND && t <= LOTTO_NUMBER_UPPER_BOUND);
    }
}