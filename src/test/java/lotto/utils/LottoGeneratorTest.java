package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또의 숫자 개수는 6개 이다.")
    void lottoNumberCountIs6() {
        //given //when
        List<Integer> lotto = LottoGenerator.generate();

        //then
        assertThat(lotto).hasSize(NumberConstants.NUMBER_COUNT.getValue());
    }

    @Test
    @DisplayName("로또의 각 번호는 1이상 45이하의 수 이다.")
    void lottoNumberGreaterThanEqual1AndLessThanEqual45() {
        //given //when
        List<Integer> lotto = LottoGenerator.generate();

        //then
        assertThat(lotto.stream()
            .allMatch(number -> NumberConstants.NUMBER_LEAST_VALUE.getValue() <= number
                && number <= NumberConstants.NUMBER_MOST_VALUE.getValue())).isTrue();
    }

    @Test
    @DisplayName("로또의 번호는 정렬되어 있다.")
    void sortLottoNumber() {
        //given //when
        List<Integer> lotto = LottoGenerator.generate();

        //then
        assertThat(lotto).isSorted();
    }
}