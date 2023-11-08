package lotto.study;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomsStudyTest {

    @DisplayName("주어진 리스트에 있는 숫자 중 하나를 반환한다.")
    @Test
    void pickNumberInList() {
        // when
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int number = Randoms.pickNumberInList(numbers);

        // then
        assertThat(number).isGreaterThanOrEqualTo(0);
        assertThat(number).isLessThanOrEqualTo(10);
    }

    @DisplayName("주어진 범위 안에 있는 숫자 중 하나를 반환한다.")
    @Test
    void pickNumberInRange() {
        // when
        int number = Randoms.pickNumberInRange(1, 10);

        // then
        assertThat(number).isGreaterThanOrEqualTo(0);
        assertThat(number).isLessThanOrEqualTo(10);
    }

    @DisplayName("설정한 범위 안에서 설정한 갯수만큼 유니크한 숫자를 반환한다.")
    @Test
    void pickUniqueNumbersInRange() {
        // when
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 10, 3);
        Set<Integer> distinctNumbers = new HashSet<>(numbers);

        // then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(distinctNumbers.size()).isEqualTo(3);

        Stream<Integer> stream = numbers.stream();
        assertThat(stream.allMatch(num -> num >= 0 && num <= 10)).isTrue();
    }
}
