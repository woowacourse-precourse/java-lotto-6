package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinTest {
    private static final String WINNING_LOTTO = "6,1,2,3,4,5";

    private final Win win = new Win();
    
    @Test
    void 당첨_번호_넣고_가져오기() {
        win.setWinningLotto(WINNING_LOTTO);

        Lotto lotto = win.getWinningLotto();
        Lotto expectedLotto = new Lotto(List.of(6, 1, 2, 3, 4, 5));

        assertThat(lotto.getNumbers()).isEqualTo(expectedLotto.getNumbers());
    }

    @Test
    void 당첨_번호_문자열에서_리스트로_변환() {
        assertThat(win.stringToList(WINNING_LOTTO)).isEqualTo(List.of(6, 1, 2, 3, 4, 5));
    }

    @Test
    void 보너스_번호_넣고_가져오기() {
        int bonus = 7;
        win.setBonus(bonus);

        assertThat(win.getBonus()).isEqualTo(bonus);
    }
}