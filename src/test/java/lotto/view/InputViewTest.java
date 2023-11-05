package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("일반 list는 값 변경이 가능해야한다.")
    @Test
    void mutableListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        list.set(0, 1000);

        assertThat(list.get(0)).isEqualTo(1000);
    }

    @DisplayName("List.of() 로 만든 리스트는 불변이다.")
    @Test
    void immutableListTest() {
        List<Integer> list = List.of(1);

        assertThatThrownBy(
                () -> list.set(0, 1000)
        ).isInstanceOf(UnsupportedOperationException.class);
    }

}

