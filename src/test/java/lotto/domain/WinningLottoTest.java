package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("올바른 입력을 주었을때 잘 생성되는지")
    @Test
    void createByRightInput() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7);

        WinningLotto winningLotto = WinningLotto.create(lotto, bonusNumber);
        assertNotNull(winningLotto, "생성된 WinningLotto 객체는 null이 아니어야 합니다.");
        assertEquals(bonusNumber, winningLotto.getBonusNumber(), "WinningLotto의 보너스 번호가 일치해야 합니다.");
    }

    @DisplayName("당첨 번호를 가지고 있는지 확인하는 기능 테스트")
    @Test
    void isContainTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7);
        WinningLotto winningLotto = WinningLotto.create(lotto, bonusNumber);
        assertTrue(winningLotto.isContain(1));
    }
}
