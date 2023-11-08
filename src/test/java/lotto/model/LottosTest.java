package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @DisplayName("Lotto 들의 결과를 출력하는 테스트")
    @Test
    void toStringTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lottos lottos = Lottos.create(List.of(lotto, lotto2));

        String expected = "[1, 2, 3, 4, 5, 6]\n" +
                "[2, 3, 4, 5, 6, 7]\n";

        assertThat(lottos.toString()).isEqualTo(expected);
    }

    @DisplayName("로또의 개수를 제대로 세는지 확인하는 테스트")
    @Test
    void size() {
        List<Integer> lottoNumber1 = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(lottoNumber1);
        List<Integer> lottoNumber2 = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = new Lotto(lottoNumber2);
        List<Lotto> lottoList = List.of(lotto1, lotto2);
        Lottos lottos = Lottos.create(lottoList);

        assertThat(lottos.size()).isEqualTo(2);
    }
}