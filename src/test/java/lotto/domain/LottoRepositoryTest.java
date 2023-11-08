package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {

    LottoRepository lottoRepository = new LottoRepository();
    Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto lotto2 = new Lotto(Arrays.asList(1, 10, 23, 34, 35, 45));

    @BeforeEach
    void setUp() {
        lottoRepository.add(lotto1);
        lottoRepository.add(lotto2);
    }

    @Test
    @DisplayName("lottoRepository size() 확인")
    void size() {
        int size = lottoRepository.size();
        assertThat(size).isEqualTo(2);
    }

    @Test
    @DisplayName("lottoRepository get() 확인")
    void get() {
        assertThat(lottoRepository.get(1)).isEqualTo(lotto2);
    }
}