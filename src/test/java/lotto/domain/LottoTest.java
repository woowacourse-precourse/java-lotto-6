package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 번호는 입력할 수 없습니다.";
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 번호의 개수는 6개입니다.";
    private static final String OUT_OF_RANGE_NUMBER_ERROR_MESSAGE = "[ERROR] 번호는 1~45 사이의 숫자여야합니다.";
    @Test
    @DisplayName("크기초과_로또_Test")
    void 크기초과_로또_Test() throws Exception {
        //given
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        //when
        //then
        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            new Lotto(list);
        });
        assertThat(exception.getMessage()).isEqualTo(SIZE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("중복번호_로또_Test")
    void 중복번호_로또_Test() throws Exception {
        //given
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);

        //when
        //then
        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            new Lotto(list);
        });
        assertThat(exception.getMessage()).isEqualTo(DUPLICATE_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("범위초과_로또_Test")
    void 범위초과_로또_Test() throws Exception {
        //given
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        //when
        //then
        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            new Lotto(list);
        });
        assertThat(exception.getMessage()).isEqualTo(OUT_OF_RANGE_NUMBER_ERROR_MESSAGE);
    }
}