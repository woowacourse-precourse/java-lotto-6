package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    Lotto lotto;
    @BeforeEach
    void setup(){
         lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또에 해당 숫자가 존재하면 true를 반환한다.")
    @Test
    void isContain() {
        assertTrue(lotto.isContain(3));
    }

    @DisplayName("로또에 해당 숫자가 존재하지 않는다면 false를 반환한다.")
    @Test
    void lottoIsNotContain(){
        assertFalse(lotto.isContain(10));
    }

    @DisplayName("로또번호 비교 기능 맞은 숫자만큼 리턴한다.")
    @Test
    void countContainsNumberSuccess() {
        Lotto computerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(6, lotto.countContainsNumber(computerLotto));
        assertNotEquals(5, lotto.countContainsNumber(computerLotto));
        assertNotEquals(4, lotto.countContainsNumber(computerLotto));
        assertNotEquals(3, lotto.countContainsNumber(computerLotto));
        assertNotEquals(2, lotto.countContainsNumber(computerLotto));
        assertNotEquals(1, lotto.countContainsNumber(computerLotto));
        assertNotEquals(0, lotto.countContainsNumber(computerLotto));
    }

}