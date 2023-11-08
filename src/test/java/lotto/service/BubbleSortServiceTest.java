package lotto.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortServiceTest {
    @DisplayName("버블 정렬이 정확히 동작한다.")
    @Test
    void testBubbleSort() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 2, 5));

        BubbleSortService.bubbleSort(list);

        assertThat(list).containsExactly(1, 2, 3, 4, 5);
    }
}