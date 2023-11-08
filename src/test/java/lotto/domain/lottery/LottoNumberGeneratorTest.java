package lotto.domain.lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.constants.LottoConstraint.NUMBER_RANGE_MAXIMUM;
import static lotto.domain.constants.LottoConstraint.NUMBER_RANGE_MINIMUM;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    private LottoNumberGenerator lottoNumberGenerator;
    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @DisplayName("로또는 6개의 숫자를 가지고 있어야 한다.")
    @Test
    void validateLottoNumberSize() {
        // When, Then
        List<Integer> numbers = lottoNumberGenerator.generateSortedLottoNumber();
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("로또의 숫자는 서로 달라야 한다.")
    @Test
    void validateLottoNumberIsIdentified() {
        // When, Then
        List<Integer> numbers = lottoNumberGenerator.generateSortedLottoNumber();
        Set<Integer>identifiedNumbers = new HashSet<>(numbers);
        assertThat(identifiedNumbers.size()).isEqualTo(numbers.size());
    }

    @DisplayName("로또의 숫자는 오름차순으로 정렬되어 있어야 한다.")
    @Test
    void validateLottoNumberIsSorted() {
        // When, Then
        List<Integer> numbers = lottoNumberGenerator.generateSortedLottoNumber();
        assertThat(numbers).isSorted();
    }

    @DisplayName("로또의 숫자의 범위는 1~45이어야 한다.")
    @Test
    void validateLottoNumberInRange() {
        // When, Then
        List<Integer> numbers = lottoNumberGenerator.generateSortedLottoNumber();
        assertThat(numbers)
                .allMatch(number -> number >= NUMBER_RANGE_MINIMUM.getValue() && number <= NUMBER_RANGE_MAXIMUM.getValue());
    }

}