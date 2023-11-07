package lotto.util;

import lotto.domain.LottoInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumbersGeneratorTest {

    @Test
    @DisplayName("랜덤한 번호 목록을 생성하고 정렬한다")
    void generateRandomNumbers() {
        // When
        List<Integer> randomNumbers = RandomNumbersGenerator.generate();

        // Then
        assertThat(randomNumbers).isNotNull();
        assertThat(randomNumbers).hasSize(LottoInfo.MAX_SIZE.getNumberInfo());
    }

    @Test
    @DisplayName("랜덤한 번호가 유효한 범위 내에 있는지 확인")
    void validateRandomNumberRange() {
        // Given
        List<Integer> randomNumbers = RandomNumbersGenerator.generate();

        // Then
        randomNumbers.forEach(number ->
                assertThat(number).isBetween(LottoInfo.MIN_NUMBER.getNumberInfo(), LottoInfo.MAX_NUMBER.getNumberInfo())
        );
    }

    @Test
    @DisplayName("랜덤한 번호 목록이 정렬되어 있는지 확인")
    void validateRandomNumberSorting() {
        // Given
        List<Integer> randomNumbers = RandomNumbersGenerator.generate();

        // Then
        List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);
        sortedNumbers.sort(Integer::compareTo);
        assertThat(randomNumbers).containsExactlyElementsOf(sortedNumbers);
    }
}