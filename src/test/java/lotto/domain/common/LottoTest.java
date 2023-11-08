package lotto.domain.common;

import lotto.exception.Lotto.LottoDuplicationException;
import lotto.exception.Lotto.LottoNotInRangeException;
import lotto.exception.Lotto.LottoNotSizeSixException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {

    @DisplayName("로또 번호는 6개의 숫자만 가능함")
    @Test
    void lottoNotSizeSixTest() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertThatThrownBy(() -> new Lotto(integers)).isInstanceOf(LottoNotSizeSixException.class);
    }

    @DisplayName("로또 번호 6개의 숫자들은 서로 중복될 수 없음")
    @Test
    void lottoDuplicationTest() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5);
        Assertions.assertThatThrownBy(() -> new Lotto(integers)).isInstanceOf(LottoDuplicationException.class);
    }

    @DisplayName("로또 번호 6개의 숫자들 1 이상 45 이하만 가능")
    @Test
    void lottoNotInRangeTest() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 46);
        Assertions.assertThatThrownBy(() -> new Lotto(integers)).isInstanceOf(LottoNotInRangeException.class);
    }
}

