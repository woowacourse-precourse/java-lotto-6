package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComparatorTest {

    @Test
    @DisplayName("로또와 당첨번호를 비교하여 같은 숫자의 개수 반환")
    void countSameNumber() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);
        Comparator comparator = new Comparator();
        Lotto winnerLotto = new Lotto(numbers);
        int result = comparator.countSameNumber(lotto, winnerLotto);
        assertThat(result).isEqualTo(6);
    }
}