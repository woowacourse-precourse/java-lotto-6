package lotto.serviceTest;

import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.repository.MemoryRandomLottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoRepository lottoRepository;
    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        lottoRepository = new MemoryRandomLottoRepository(); // Initialize the memory repository
        lottoService = new LottoServiceImpl(lottoRepository);
    }

    @DisplayName("로또서비스 기록기능 테스트")
    @Test
    public void testRecordLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoService.recordLotto(lotto);

        List<Lotto> lottos = lottoRepository.getLottoList(); // Get lottos from the memory repository

        assertThat(lottos).contains(lotto); // Check if the lotto is stored in the memory repository
    }

    @DisplayName("로또서비스 조회기능 테스트")
    @Test
    public void testGetAllLottoRecord() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        lottoRepository.save(lotto1);
        lottoRepository.save(lotto2);

        List<Lotto> lottos = lottoService.getAllLottoRecord(); // Get all lotto records

        assertThat(lottos).contains(lotto1, lotto2); // Check if the expected lotto records are returned
    }
}