package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨된 로또가 보너스번호를 포함하는지 확인한다.")
    @Test
    void hasBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(lotto, 6);

        Assertions.assertAll(
                () -> Assertions.assertTrue(winningLotto.hasBonusNumber(5,
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)))),
                () -> Assertions.assertFalse(winningLotto.hasBonusNumber(3,
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)))),
                () -> Assertions.assertFalse(winningLotto.hasBonusNumber(5,
                        new Lotto(List.of(8, 9, 10, 11, 12, 13)))),
                () -> Assertions.assertFalse(winningLotto.hasBonusNumber(3,
                        new Lotto(List.of(8, 9, 10, 11, 12, 13))))
        );
    }
}
