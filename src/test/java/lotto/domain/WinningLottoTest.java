package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningLottoTest {
    @DisplayName("당첨 로또와 비교하여 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,7,8:FOURTH", "1,2,3,7,8,9:FIFTH", "1,2,7,8,9,10:MISS", "11,12,13,14,15,16:MISS"}, delimiter = ':')
    void checkLotto(String numbers, Rank expected) {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Integer> targetNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
        Lotto lotto = new Lotto(targetNumbers);
        assertThat(winningLotto.match(lotto)).isEqualTo(expected);
    }
}