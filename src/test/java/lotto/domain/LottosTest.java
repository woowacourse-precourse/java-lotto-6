package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("모든 Lotto의 번호를 가져온다")
    @Test
    void getsAllLottoNumber() {
        // given
        List<Lotto> lotto = List.of(
                new Lotto(List.of(43, 21, 23, 42, 41, 8)),
                new Lotto(List.of(5, 3, 16, 11, 38, 32)),
                new Lotto(List.of(22, 45, 5, 14, 1, 3))
        );
        Lottos lottos = new Lottos(lotto);

        // when
        List<String> lottosNumber = lottos.getLottosAllSortedNumber();

        // then
        assertThat(lottosNumber)
                .isEqualTo(List.of(
                        "[8, 21, 23, 41, 42, 43]",
                        "[3, 5, 11, 16, 32, 38]",
                        "[1, 3, 5, 14, 22, 45]"));
    }

    @DisplayName("Lottos에 포함된 Lotto의 개수를 가져온다")
    @Test
    void getLottosAmount() {
        // given
        List<Lotto> lotto = List.of(
                new Lotto(List.of(43, 21, 23, 42, 41, 8)),
                new Lotto(List.of(5, 3, 16, 11, 38, 32)),
                new Lotto(List.of(22, 45, 5, 14, 1, 3))
        );
        Lottos lottos = new Lottos(lotto);

        // when
        int lottosAmount = lottos.getLottosAmount();

        // then
        assertThat(lottosAmount)
                .isEqualTo(3);
    }

}