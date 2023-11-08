package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class SetTest {
    final List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5, 5));

    @DisplayName("list값이 set에 잘 복사되는지 확인")
    @Test
    void DuplicateSetTest() {
        Set<Integer> temp = new HashSet<>(numbers);
        assertThat(temp.size()).isEqualTo(5);
    }
}
