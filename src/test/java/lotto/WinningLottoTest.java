package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    public void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningLotto = new WinningLotto(lotto1, bonusNumber);
    }

    @DisplayName("당첨 횟수가 일치하는지 테스트")
    @Test
    public void createTotalPrize() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 8)); // 3등
        List<Lotto> lottos = List.of(lotto1, lotto2);

        List<Prize> prizes = winningLotto.calculateTotalPrize(lottos);

        assertEquals(Prize.SECOND, prizes.get(0));
        assertEquals(Prize.THIRD, prizes.get(1));
    }
}
