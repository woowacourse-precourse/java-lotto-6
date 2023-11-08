package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashSetTest {

    @DisplayName("HashSet add()는 중복된 값을 제외하고 저장한다.")
    @Test
    void hashSet_add() {
        //given
        Set<Integer> numbers = new HashSet<>();

        //when
        numbers.add(3);
        numbers.add(2);
        numbers.add(3);

        //then
        assertThat(numbers).hasSize(2);
        assertThat(numbers).contains(2,3);
    }

    @DisplayName("HashSet add()는 중복된 값이 있을 경우 false 리턴해준다.")
    @Test
    void hashSet_addable() {
        //given
        Set<Integer> numbers = new HashSet<>();

        //when
        numbers.add(3);
        numbers.add(2);
        boolean isAddable = numbers.add(3);

        //then
        assertThat(isAddable).isFalse();
    }

}
