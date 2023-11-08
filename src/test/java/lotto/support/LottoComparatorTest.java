package lotto.support;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoComparatorTest {

    @DisplayName("Comparator가 잘 작동하는지(1등 테스트)")
    @Test
    void testComparator() {
        LottoComparator lottoComparator = new LottoComparator(new Lotto(List.of(1, 3, 5, 7, 9, 11)), 13);

        assertThat(lottoComparator.compareLotto(new Lotto(List.of(1, 3, 5, 7, 9, 11))))
                .isEqualTo(Rate.FIRST);
    }

    @DisplayName("Comparator가 잘 작동하는지(2등 테스트)")
    @Test
    void testComparator2() {
        LottoComparator lottoComparator = new LottoComparator(new Lotto(List.of(1, 3, 5, 7, 9, 11)), 13);

        assertThat(lottoComparator.compareLotto(new Lotto(List.of(1, 3, 5, 7, 9, 13))))
                .isEqualTo(Rate.SECOND);
    }

}