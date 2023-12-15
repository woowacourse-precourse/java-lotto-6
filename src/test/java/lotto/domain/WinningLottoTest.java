package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void validateDistinctBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        Assertions.assertThatThrownBy(() -> {
                    new WinningLotto(lotto, bonusNumber);
                })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
