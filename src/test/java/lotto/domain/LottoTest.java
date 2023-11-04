package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또에 해당 숫자가 존재하면 true를 반환한다.")
    @Test
    void isContain() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertTrue(lotto.isContain(3));
    }

    @DisplayName("로또에 해당 숫자가 존재하지 않는다면 false를 반환한다.")
    @Test
    void lottoIsNotContain(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertFalse(lotto.isContain(10));
    }
}