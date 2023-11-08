package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindNumInListServiceTest {
    @DisplayName("리스트에서 특정 숫자의 출현 횟수를 정확히 센다.")
    @Test
    void testCountOccurrences() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 2, 5, 2);
        int target = 2;

        int occurrences = FindNumInListService.countOccurrences(list, target);

        assertThat(occurrences).isEqualTo(4);
    }

    @DisplayName("리스트에서 출현하지 않는 숫자의 출현 횟수는 0이다.")
    @Test
    void testCountOccurrences_NotInList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int target = 6; // 리스트에 없는 숫자

        int occurrences = FindNumInListService.countOccurrences(list, target);

        assertThat(occurrences).isEqualTo(0);
    }
}