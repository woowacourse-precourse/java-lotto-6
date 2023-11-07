package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("로또가 지정한 개수만큼 생성돼야 한다.")
    @Test
    void createLottos() {
        //given
        Lottos lottos1 = new Lottos(new ArrayList<>());
        Lottos lottos2 = new Lottos(new ArrayList<>());

        //when
        lottos1.createLottos(10);
        lottos2.createLottos(7);

        //then
        assertThat(lottos1.getLottosSize() == 10);
        assertThat(lottos2.getLottosSize() == 7);

    }


    @DisplayName("로또들의 당첨 개수가 모두 6이어야 한다.")
    @Test
    void checkWinnings() {
        //given
        Lottos lottos = new Lottos(new ArrayList<>());
        lottos.createLottos(4, 1, 6, 6);

        //when
        int[] winningNum = lottos.checkWinnings(new int[]{1, 2, 3, 4, 5, 6}, 7);

        //then
        for(int i = 0; i < winningNum.length; i++) {
            assertThat(winningNum[i] == 6);
        }
    }
}