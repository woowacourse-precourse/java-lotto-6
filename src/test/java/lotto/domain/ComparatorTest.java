package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class ComparatorTest {

    @Test
    @DisplayName("로또와 당첨번호를 비교하여 중복되는 수의 개수 찾기")
    void 중복_개수() {
        //given
        Comparator comparator = new Comparator();
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> lucky = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11));

        //when
        int count = comparator.compare(lotto, lucky);

        //then
        Assertions.assertThat(count).isEqualTo(3);
    }
}