package lotto.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {
    LottoRepository lottoRepository;

    @BeforeEach
    void init() {
        LottoRepository.resetInstance();
        LottoRepository.resetField();
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

}
