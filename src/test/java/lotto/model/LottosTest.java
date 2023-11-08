package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @Test
    void getResults() {

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

        Assertions.assertThat(lottos.size()).isEqualTo(2);
    }
}