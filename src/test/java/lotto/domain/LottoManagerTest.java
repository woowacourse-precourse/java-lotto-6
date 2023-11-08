package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {
    @Test
    @DisplayName("당첨 번호와 로또번호가 같은 개수를 리스트에 담는 테스트")
    void test() {
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 33);
        List<Integer> lotto2 = List.of(1, 2, 3, 4, 5, 44);
        List<Integer> userNumber = List.of(1, 2, 3, 4, 5, 44);
        int bonusNumber = 33;
        List<Lotto> lottos = List.of(new Lotto(lotto1), new Lotto(lotto2));
        LottoManager lottoManager = new LottoManager(2);

        assertThat(lottoManager.sameNumberForWin(userNumber, lottos, bonusNumber)).containsExactly(0, 0, 0, 0, 0, 0, 1, 1);
    }

}