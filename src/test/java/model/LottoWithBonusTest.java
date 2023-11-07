package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWithBonusTest {

    @Test
    void 보너스_번호가_같을_때_true_반환() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWithBonus lottoWithBonus1 = new LottoWithBonus(lotto, LottoNumber.from(1));
        LottoWithBonus lottoWithBonus2 = new LottoWithBonus(lotto, LottoNumber.from(1));

        // when & then
        assertTrue(lottoWithBonus1.hasSameBonusNumber(lottoWithBonus2));
    }

    @Test
    void 보너스_번호가_다를_때_false_반환() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWithBonus lottoWithBonus1 = new LottoWithBonus(lotto, LottoNumber.from(1));
        LottoWithBonus lottoWithBonus2 = new LottoWithBonus(lotto, LottoNumber.from(2));

        // when & then
        assertFalse(lottoWithBonus1.hasSameBonusNumber(lottoWithBonus2));
    }
}
