package lotto.domain;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusLottoTest {

    @Test
    void 로또번호와_같은숫자() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusLotto(1, new Lotto(List.of(1,2,3,4,5,6)));});
    }

    @Test
    void 범위_넘는_숫자() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusLotto(100, new Lotto(List.of(1,2,3,4,5,6)));});
    }

}