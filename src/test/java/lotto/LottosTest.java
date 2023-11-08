package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;
    @Test
    @DisplayName("로또 개수 확인 테스트")
    void getSize() {
        int size = lottos.getSize();
        assertThat(size).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 번호 출력 테스트")
    void toStringTest() {
        String expected = "[1, 2, 3, 4, 5, 6] \n[7, 8, 9, 10, 11, 12]";
        String actual = lottos.toString();
        assertThat(actual).isEqualTo(expected);
    }
}
