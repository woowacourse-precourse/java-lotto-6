package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoEnvelopTest {
    private LottoEnvelop lottoEnvelop;
    private Lotto lotto_1;
    private Lotto lotto_2;
    private Lotto lotto_3;

    @BeforeEach
    void setUp() {
        lottoEnvelop = new LottoEnvelop();
        lotto_1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto_2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        lotto_3 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
    }

    @DisplayName("봉투에 로또를 추가한다.")
    @Test
    void add() {
        // when
        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);

        Integer result = lottoEnvelop.size();

        // then
        assertThat(result).isEqualTo(3);
    }
}