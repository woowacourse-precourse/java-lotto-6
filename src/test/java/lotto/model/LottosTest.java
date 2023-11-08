package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {
    @DisplayName("당첨 번호와 로또 번호의 맞은 개수가 일치하는지 테스트한다.")
    @Test
    void lottoMatchingCount() {
        //given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(7,8,9,10,11,12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,8,20));

        //when
        List<Integer> result = lottos.calcurateLottoCounts(winningNumber);

        //then
        assertThat(result).isEqualTo(List.of(4,1));
    }
}