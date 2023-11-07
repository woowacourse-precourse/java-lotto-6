package lotto.domain;

import lotto.config.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {
    private static final int RANGE_START = LottoConfig.RANGE_START.value();
    private static final int RANGE_END = LottoConfig.RANGE_END.value();
    private static final int SIZE = LottoConfig.SIZE.value();

    @DisplayName("랜덤한 로또 번호의 개수가 6개인지 확인한다.")
    @RepeatedTest(100)
    void checkRandomLottoSize() {
        List<Integer> randomNumbers = LottoNumberGenerator.generate();
        assertThat(randomNumbers).hasSize(SIZE);
    }

    @DisplayName("랜덤한 로또 번호에 범위를 벗어난 숫자가 있는지 확인한다.")
    @RepeatedTest(100)
    void checkRandomLottoRange() {
        List<Integer> randomNumbers = LottoNumberGenerator.generate();
        assertThat(randomNumbers)
                .filteredOn(number -> number < RANGE_START || number > RANGE_END)
                .hasSize(0);
    }

    @DisplayName("랜덤한 로또 번호에 중복된 숫자가 있는지 확인한다.")
    @RepeatedTest(100)
    void checkRandomLottoDuplicates() {
        List<Integer> randomNumbers = LottoNumberGenerator.generate();
        assertThat(new HashSet<>(randomNumbers)).hasSize(SIZE);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되는지 확인한다.")
    @Test
    void checkRandomLottoSort() {
        List<Integer> sortedNumbers = LottoNumberGenerator.sort(List.of(3, 32, 1, 7, 6, 45));
        assertThat(sortedNumbers).containsExactly(1, 3, 6, 7, 32, 45);
    }
}
