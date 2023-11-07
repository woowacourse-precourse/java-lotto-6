package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionsApiTest {

    @Test
    @DisplayName("Collections의 frequency메서드는 특정 원소의 개수를 반환한다.")
    void returnContainElementCountInCollection() {
        //given
        List<Integer> target = List.of(1, 1, 1, 2, 3, 4, 5);
        //when
        int result = Collections.frequency(target, 1);
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Collections의 frequency메서드는 특정 원소가 없을 경우 0을 반환한다.")
    void return0NotContainElementCountInCollection() {
        //given
        List<Integer> target = List.of(1, 2, 3, 4, 5);
        //when
        int result = Collections.frequency(target, 6);
        //then
        assertThat(result).isEqualTo(0);
    }
}
