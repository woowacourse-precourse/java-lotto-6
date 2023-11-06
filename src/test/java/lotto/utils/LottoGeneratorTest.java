package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LottoGeneratorTest {

    @DisplayName("로또 번호 생성기가 6개의 숫자 list를 반환하는지 테스트")
    @Test
    void generateLottoNumTest() {
        // given
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        // when
        int result = numbers.size();

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("로또 번호 생성기의 6개의 숫자가 모두 중복되지 않은지 테스트")
    @Test
    void validateRedundancy() {
        // given
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        // when
        Set<Integer> redundancyFilter = new HashSet<>(numbers);
        int result = redundancyFilter.size();

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 현재 뽑은 로또 번호와 중복되지 않은지 테스트")
    @Test
    void validateBonusRedundancy() {
        // given
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        // when
        int result = LottoGenerator.generateBonusNumber(numbers);

        // then
        assertFalse(numbers.contains(result));
    }

}
