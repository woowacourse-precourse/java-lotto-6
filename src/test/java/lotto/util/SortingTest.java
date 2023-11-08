package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortingTest {

    @DisplayName("정수형 리스트를 오름차순으로 정렬한다.")
    @Test
    void listNaturalOrder() {
        List<Integer> orderedList = Sorting.getListNaturalOrder(List.of(5, 3, 6, 28, 14, 12));

        assertThat(orderedList).isEqualTo(List.of(3, 5, 6, 12, 14, 28));
    }
}
