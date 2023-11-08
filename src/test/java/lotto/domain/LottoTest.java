package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("isContain 메서드가 정상 작동하는지")
    @Test
    void isContainTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.isContain(4)).isTrue();
        assertThat(lotto.isContain(7)).isFalse();
    }

    @DisplayName("당첨 로또 번호와 일치하는 숫자 개수 구하기")
    @Test
    void getMatchCountTest() {
        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,7,8));
        assertThat(winningLotto.getMatchCount(userLotto))
                .isEqualTo(4);
    }

    @DisplayName("생성자에 의해 정상적으로 정렬 되는지")
    @Test
    void sortNumbersTest() {
        Lotto lotto = new Lotto(Arrays.asList(6,4,5,3,2,1));
        assertThat(lotto.toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
