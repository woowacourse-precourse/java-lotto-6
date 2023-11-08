package lotto.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    List<Integer> lotto;

    @BeforeEach
    void init() {
        lotto = LottoGenerator.createLotto();
    }

    @DisplayName("로또의 길이는 6이어야 한다.")
    @Test
    void lottoSize() {
        assertEquals(lotto.size(), 6);
    }

    @DisplayName("로또 번호는 1~45 사이의 숫자여야 한다.")
    @Test
    void lottoRange() {
        for(Integer number : lotto) {
            assertThat(number).isGreaterThan(0).isLessThan(46);
        }
    }

    @DisplayName("로또 번호는 중복이 되면 안 된다.")
    @Test
    void lottoUnique() {
        boolean[] isContained = new boolean[46];
        for(Integer number : lotto) {
            assertFalse(isContained[number]);
            isContained[number] = true;
        }
    }

}
