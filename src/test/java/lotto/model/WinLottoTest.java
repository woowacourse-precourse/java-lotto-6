package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinLottoTest {

    @Test
    void 당첨번호와_보너스_번호가_중복되면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinLotto(lotto, new LottoNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
