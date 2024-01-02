package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또번호_크기_검사_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_중복_검사_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 6, 6);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_비교_테스트() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lotto1.equals(lotto2))
                .isEqualTo(true);
    }
}
