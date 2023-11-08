package lotto;

import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.configuration.GameConfig.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @DisplayName("unique한 값만을 포함한다.")
    @Test
    void uniquenessTest() {
        //given
        //when
        List<Integer> result = LottoNumberGenerator.generateRandomLottoNumber();

        //then
        assertThat(result).doesNotHaveDuplicates();
    }

    @DisplayName("지정한 개수의 원소를 포함한다.")
    @Test
    void numberOfElementTest() {
        //given
        int expectedNumber = 6;
        //when
        List<Integer> result = LottoNumberGenerator.generateRandomLottoNumber();
        //then
        assertThat(result)
                .hasSize(expectedNumber);
    }

    @DisplayName("지정한 범위 내의 수만을 포함한다.")
    @Test
    void numberRangeTest() {
        //given
        //when
        List<Integer> result = LottoNumberGenerator.generateRandomLottoNumber();
        //then
        assertThat(result)
                .allMatch(t -> t >= LOTTO_NUMBER_LOWER_BOUND && t <= LOTTO_NUMBER_UPPER_BOUND);
    }
}