package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {
    LottoRepository lottoRepository;

    @BeforeEach
    void init() {
        LottoRepository.resetInstanceAndFields();
    }

    @Test
    void 싱글톤_존재_테스트() {
        lottoRepository = LottoRepository.getInstance();
        assertNotNull(lottoRepository);
    }

    @Test
    void 싱글톤_유일성_테스트() {
        lottoRepository = LottoRepository.getInstance();
        LottoRepository lottoRepository2 = LottoRepository.getInstance();

        assertSame(lottoRepository, lottoRepository2);
    }

    @Test
    void lottoRepository_save_테스트() {
        lottoRepository = LottoRepository.getInstance();
        lottoRepository.save(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<Lotto> lottos = LottoRepository.getLottos();
        Lotto actual = lottos.get(0);

        Lotto expected = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        expected.id = 0L;

        assertThat(lottos.size()).isEqualTo(1);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
