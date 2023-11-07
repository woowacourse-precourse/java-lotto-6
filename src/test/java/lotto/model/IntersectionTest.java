package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IntersectionTest {

    @DisplayName("당첨 번호 비교")
    @Test
    void countMatchingNumbers() {
        Intersection intersection = new Intersection();
        List<Integer> winNum = List.of(1, 11, 5, 24, 3, 7);
        List<Set> lottoNum = List.of(Set.of(1, 11, 5, 24, 3, 8));
        List<Integer> result = intersection.countMatchingNumbers(winNum, lottoNum);
        assertThat(result).isEqualTo(List.of(5));
    }

    @DisplayName("보너스 번호 비교")
    @Test
    void checkBonusNumber() {
        Intersection intersection = new Intersection();
        List<Set> numbers = List.of(Set.of(1, 11, 5, 24, 3, 7));
        List result = intersection.checkBonusNumber("1", numbers);
        assertThat(result).isEqualTo(List.of(true));
    }
}