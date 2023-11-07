package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("중복된 숫자로는 로또가 생성이 안되고 예외발생")
    @Test
    void generateLotto1() {
        //when
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        //given & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6자리 이상 리스트로는 로또가 생성이 안되고 예외발생")
    @Test
    void generateLotto2() {
        //when
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //given & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 넘어간 숫자를 가진 리스트로는 로또가 생성이 안되고 예외발생")
    @Test
    void generateLotto3() {
        //when
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        //given & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}