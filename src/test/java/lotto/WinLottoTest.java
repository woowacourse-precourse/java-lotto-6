package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

    @DisplayName("우승로또 번호는 보너스 번호와 중복될 수 없다.")
    @Test
    void create() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = LottoNumber.getInstance(1);

        assertThatThrownBy(() -> WinLotto.of(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
