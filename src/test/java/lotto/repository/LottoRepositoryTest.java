package lotto.repository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import lotto.model.Lotto;
import org.junit.jupiter.api.*;

class LottoRepositoryTest {

    private LottoRepository lottoRepository;
    private Lotto lotto1;
    private Lotto lotto2;


    @BeforeEach
    void setUp() {
        lottoRepository = LottoRepository.getInstance();
        lottoRepository.clear();

        lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45));
    }

    @Test
    @DisplayName("Lotto 객체 추가 테스트")
    void testSaveLotto() {
        // When
        lottoRepository.saveLotto(lotto1);
        lottoRepository.saveLotto(lotto2);

        // Then
        assertEquals(2, lottoRepository.findNumberOfUserLotto());
    }

    @Test
    @DisplayName("Lotto List 탐색 테스트")
    void testSearchLottoList() {
        // Given
        lottoRepository.saveLotto(lotto1);
        lottoRepository.saveLotto(lotto2);
        Integer numberOfLotto = lottoRepository.findNumberOfUserLotto();

        // When
        Lotto nextLotto1 = lottoRepository.findUserLottoByIndex(0);
        Lotto nextLotto2 = lottoRepository.findUserLottoByIndex(1);

        // Then
        assertEquals(nextLotto1, lotto1);
        assertEquals(nextLotto2, lotto2);

        assertThatThrownBy(() -> lottoRepository.findUserLottoByIndex(numberOfLotto))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}

